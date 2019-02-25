package com.cobra.sell.service.impl;

import com.cobra.sell.converter.OrderMaster2OrderDTOConverter;
import com.cobra.sell.dataobject.OrderDetail;
import com.cobra.sell.dataobject.OrderMaster;
import com.cobra.sell.dataobject.ProductInfo;
import com.cobra.sell.dto.CartDTO;
import com.cobra.sell.dto.OrderDTO;
import com.cobra.sell.enums.OrderStausEnum;
import com.cobra.sell.enums.PayStausEnum;
import com.cobra.sell.enums.ResultEnum;
import com.cobra.sell.exception.SellException;
import com.cobra.sell.repository.OrderDetailRepository;
import com.cobra.sell.repository.OrderMasterRepository;
import com.cobra.sell.service.*;
import com.cobra.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Collection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 13:45
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private PayService payService;

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private WebSocket webSocket;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();

        BigDecimal orderAmuont = new BigDecimal(BigInteger.ZERO);

//        List<CartDTO> cartDTOList = new ArrayList<>();

        //（价格需要去数据库获取）
        // 1.查询商品（数量、价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo==null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总计总价
            orderAmuont = productInfo.getProductPrice().
                    multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmuont);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
//            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }
        //
        // 3.写入订单数据库(orderMaster)
        OrderMaster orderMaster = new OrderMaster();
        //属性拷贝，如果属性为null，也会被复制进去
        //注意属性拷贝和设置的先后顺序
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmuont);
        orderMaster.setOrderStatus(OrderStausEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStausEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        // 4.扣库存(lambda表达式)--（人多并发时会有问题，后续用redis锁优化）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
            new CartDTO(e.getProductId(),e.getProductQuantity())
        ).collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);

        //发送消息websocket消息
        webSocket.sendMessage(orderDTO.getOrderId());

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if (orderMaster==null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList =  orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        //获取原始数据
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid,pageable);
        //转换数据
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());
        //构造返回
        return new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();

        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStausEnum.NEW.getCode())){
            log.error("【取消订单】订单状态不正确，orderId={}，orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStausEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult==null) {
            log.error("【取消订单】更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返还库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【取消订单】订单中无商品详情，orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()) )
                .collect(Collectors.toList());
        productInfoService.increaseStock(cartDTOList);
        //如果已经支付需要退款
        if (orderDTO.getPayStatus().equals(PayStausEnum.SUCCESS.getCode())) {
            payService.refound(orderDTO);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStausEnum.NEW.getCode())) {
            log.error("【完结订单】订单状态不正确，orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStausEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult==null) {
            log.error("【完结订单】更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        // 1.推送微信模板消息,可以根据业务，在不同的订单过程中不同地方推送，
        // 方法没有直接抛异常，已经try-catch，失败不会回滚，不影响支付，修改订单状态等主要业务
        pushMessageService.orderStatus(orderDTO);

        return orderDTO;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStausEnum.NEW.getCode())) {
            log.error("【订单支付成功】订单状态不正确，orderId={},orderStatus={}",
                    orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStausEnum.WAIT.getCode())) {
            log.error("【订单支付完成】订单支付状态不正确，orderDIO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_PAY_ERROR);
        }
        //修改支付状态
        orderDTO.setPayStatus(PayStausEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult==null) {
            log.error("【订单支付完成】更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
        //转换数据
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());
        //构造返回
        return new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());
    }
}
