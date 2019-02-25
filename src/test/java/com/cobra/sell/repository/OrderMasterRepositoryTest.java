package com.cobra.sell.repository;

import com.cobra.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 13:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void savetest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456788");
        orderMaster.setBuyerPhone("15869137155");
        orderMaster.setBuyerName("xiaoli");
        orderMaster.setBuyerAddress("益乐新村");
        orderMaster.setBuyerOpenid("reiujngiqiu44ffdqe8r09fjaf");
        orderMaster.setOrderAmount(new BigDecimal(0.03));
        OrderMaster result =  orderMasterRepository.save(orderMaster);
        System.out.println(result);
        Assert.assertEquals(new BigDecimal(0.03),result.getOrderAmount());
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 10);
        Page page = orderMasterRepository.findByBuyerOpenid("reiujngiqiu44ffdqe8r09fjaf",pageRequest);
        System.out.println(page);
        Assert.assertNotEquals(0,page.getTotalElements());
    }

    @Test
    public void updatetest() {
        OrderMaster orderMaster = orderMasterRepository.findOne("123456782");
        orderMaster.setOrderAmount(new BigDecimal(0.50));
        orderMaster.setBuyerName("xiaoyao");
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertEquals("xiaoyao",result.getBuyerName());
    }
}