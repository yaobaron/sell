package com.cobra.sell.repository;

import com.cobra.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/6 22:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private  ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱",4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotEquals(0,result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List list = Arrays.asList(1,7);
        /*list.add(new Integer(1));
        list.add(new Integer(7));*/
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(list);
        System.out.println(productCategoryList);
        Assert.assertNotEquals(0,productCategoryList.size());
    }
}