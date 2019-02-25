package com.cobra.sell.repository;

import com.cobra.sell.dataobject.SellerInfo;
import com.cobra.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.image.Kernel;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/13 21:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid("654321");
        Assert.assertEquals("Baron",sellerInfo.getUsername());
    }

    @Test
    public void saveTest(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("Baron");
        sellerInfo.setPassword("123456");
        sellerInfo.setOpenid("654321");
        SellerInfo sellerInfo1 = sellerInfoRepository.save(sellerInfo);
        Assert.assertEquals("654321",sellerInfo1.getOpenid());
    }
}