package com.cobra.sell.service.impl;

import com.cobra.sell.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/17 5:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1547606949860855268");
        System.out.println(orderDTO);
        pushMessageService.orderStatus(orderDTO);
    }
}