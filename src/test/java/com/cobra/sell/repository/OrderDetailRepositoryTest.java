package com.cobra.sell.repository;

import com.cobra.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 13:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void savetest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567891");
        orderDetail.setOrderId("123456780");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal(0.02));
        orderDetail.setProductQuantity(new Integer(1));
        orderDetail.setProductIcon("http:fdajfka.jpg");
        OrderDetail result = orderDetailRepository.save(orderDetail);
        System.out.println(result);
        Assert.assertEquals("皮蛋瘦肉粥",result.getProductName());
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("123456780");
        System.out.println(orderDetailList);
        Assert.assertEquals(2,orderDetailList.size());
    }
}