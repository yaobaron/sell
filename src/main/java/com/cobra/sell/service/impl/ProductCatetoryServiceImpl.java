package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.ProductCategory;
import com.cobra.sell.repository.ProductCategoryRepository;
import com.cobra.sell.service.ProductCatetoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 1:10
 */
@Service
public class ProductCatetoryServiceImpl implements ProductCatetoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
