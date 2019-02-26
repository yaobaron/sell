package com.cobra.sell.service.impl;

import com.cobra.sell.dto.OrderDTO;
import com.cobra.sell.enums.ResultEnum;
import com.cobra.sell.exception.SellException;
import com.cobra.sell.service.OrderService;
import com.cobra.sell.service.PayService;
import com.cobra.sell.utils.JsonUtill;
import com.cobra.sell.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Baron
 * @Description: 支付Service
 * @Date: Created in 2019/1/15 3:19
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    /**
     * 发起支付
     *
     * @param orderDTO
     * @return
     */
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        //这个openid使用的是租用账号信息里的openid
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】，发起支付 request={}", JsonUtill.toJson(payRequest));
        PayResponse response = bestPayService.pay(payRequest);
        log.info("【微信支付】，发起支付 response={}", JsonUtill.toJson(response));
        return response;
    }

    /**
     * 异步通知
     *
     * @param notifyData
     * @return
     */
    @Override
    public PayResponse notify(String notifyData) {
        //1.验证签名
        //2.支付状态
        //前两部分sdk已经做好
        //3.支付金额
        //4.支付人（下单人===支付人）
        PayResponse response = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】，异步通知，response={}", response);
        //查询订单
        OrderDTO orderDTO = orderService.findOne(response.getOrderId());
        //判断订单是否存在
        if (orderDTO == null) {
            log.error("【】异步通知，订单不存在，orderId={}", response.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //判断金额是否一致(0.10  0.1)
        /*if (!orderDTO.getOrderAmount().equals(response.getOrderAmount())) {
            log.error("【微信支付】异步通知，订单金额不一致，orderId={},微信通知金额={}，系统金额={}",
                    response.getOrderId(),response.getOrderAmount(),orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }*/
        //if (orderDTO.getOrderAmount().compareTo(new BigDecimal(response.getOrderAmount()))!=0) {
        if (!MathUtil.equals(response.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知，订单金额不一致，orderId={},微信通知金额={}，系统金额={}",
                    response.getOrderId(), response.getOrderAmount(), orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }
        orderService.paid(orderDTO);
        return response;
    }

    /**
     * 退款
     *
     * @param orderDTO
     * @return
     */
    @Override
    public RefundResponse refound(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】，refundRequest={}", JsonUtill.toJson(refundRequest));
        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】，refundResponse={}", JsonUtill.toJson(refundResponse));
        return refundResponse;
    }
}