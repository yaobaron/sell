package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.OrderDetail;
import com.cobra.sell.dto.CartDTO;
import com.cobra.sell.dto.OrderDTO;
import com.cobra.sell.enums.PayStausEnum;
import com.cobra.sell.repository.OrderDetailRepository;
import com.cobra.sell.repository.OrderMasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 16:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID = "dfi0oireigdfgkljroitrot34g";

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("xiaozhang");
        orderDTO.setBuyerAddress("浙江图书馆");
        orderDTO.setBuyerPhone("15869130000");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail od = new OrderDetail();
        od.setProductId("123123");
        od.setProductQuantity(2);
        OrderDetail od1 = new OrderDetail();
        od1.setProductId("123469");
        od1.setProductQuantity(2);
        orderDetailList.add(od);
        orderDetailList.add(od1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("result={}",result);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne("1547111648891126149");
        log.info("orderDTO={}",orderDTO);
        Assert.assertEquals("1547111648891126149",orderDTO.getOrderId());
        Assert.assertEquals(2,orderDTO.getOrderDetailList().size());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0, 6);
        Page<OrderDTO> page = orderService.findList(BUYER_OPENID, pageRequest);
        log.info("elementsize={},content={}", page.getTotalElements(),page.getContent());
        Assert.assertNotNull(page);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1547117006864121210");
        OrderDTO result = orderService.cancel(orderDTO);
        log.info("result={}",result);
        Assert.assertEquals(new Integer(2),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1547111648891126149");
        OrderDTO result = orderService.finish(orderDTO);
        log.info("result={}",result);
        Assert.assertEquals(new Integer(1),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1547111542873930524");
        OrderDTO result = orderService.paid(orderDTO);
        log.info("result={}",result);
        Assert.assertEquals(PayStausEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void findListByPage() {
        PageRequest pageRequest = new PageRequest(1, 6);
        Page<OrderDTO> page = orderService.findList(pageRequest);
        log.info("elementsize={},content={}", page.getTotalElements(),page.getContent());
        //Assert.assertNotNull(page);
        Assert.assertTrue("查询所有订单的列表",page.getNumberOfElements()>0);
    }
}