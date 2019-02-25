package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/13 22:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {

    @Autowired
    private SellerInfoServiceImpl sellerInfoService;

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo result = sellerInfoService.findSellerInfoByOpenid("654321");
        Assert.assertEquals("Baron",result.getUsername());
    }
}