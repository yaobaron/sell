package com.cobra.sell.service.impl;

import com.cobra.sell.dto.OrderDTO;
import com.cobra.sell.service.OrderService;
import com.cobra.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/15 12:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1547110001162537870");
        payService.create(orderDTO);
    }

    @Test
    public void refoundtest() {
        OrderDTO orderDTO = orderService.findOne("1547605844677594484");
        payService.refound(orderDTO);
    }
}