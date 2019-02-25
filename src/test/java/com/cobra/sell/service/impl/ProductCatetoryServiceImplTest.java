package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Baron
 * @Description: 测试类
 * @Date: Created in 2019/1/7 1:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCatetoryServiceImplTest {

    @Autowired
    ProductCategoryServiceImpl productCatetoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCatetoryService.findOne(8);
        Assert.assertEquals(new Integer(9), productCategory.getCategoryType());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = productCatetoryService.findAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List list = Arrays.asList(2, 7);
        List<ProductCategory> productCategoryList = productCatetoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = productCatetoryService.findOne(new Integer(8));
        productCategory.setCategoryType(new Integer(9));
        productCategory.setCategoryName("男生喜爱");
        ProductCategory productCategory1 = productCatetoryService.save(productCategory);
        Assert.assertEquals(new Integer(9), productCategory1.getCategoryType());
    }
}