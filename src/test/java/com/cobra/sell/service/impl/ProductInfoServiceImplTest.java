package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("皮蛋瘦肉粥",productInfo.getProductName());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,10);
        Page<ProductInfo> infoPage = productInfoService.findAll(pageRequest);
        System.out.println(infoPage.getContent());
        Assert.assertNotEquals(0,infoPage.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productInfoService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123123");
        productInfo.setProductName("炸鸡翅");
        productInfo.setProductPrice(new BigDecimal(1.5));
        productInfo.setProductStock(120);
        productInfo.setProductDescription("夏夜炸鸡配啤酒");
        productInfo.setProductIcon("http://zxcvbn.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertEquals(new Integer(120),result.getProductStock());
    }

    @Test
    public void onSaleTest() {
        ProductInfo productInfo = productInfoService.onSale("123123");
        Assert.assertEquals(new Integer(0),productInfo.getProductStatus());
    }

    @Test
    public void offSaleTest() {
        ProductInfo productInfo = productInfoService.offSale("123123");
        Assert.assertEquals(new Integer(1),productInfo.getProductStatus());
    }
}