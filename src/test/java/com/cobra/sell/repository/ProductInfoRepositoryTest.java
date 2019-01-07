package com.cobra.sell.repository;

import com.cobra.sell.dataobject.ProductInfo;
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
 * @Date: Created in 2019/1/7 9:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(1.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("早餐夜宵首选");
        productInfo.setProductIcon("http://?????.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        System.out.println(productInfoRepository.toString());
        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertEquals(new Integer(1),result.getCategoryType());
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.assertEquals(1,list.size());
    }
}