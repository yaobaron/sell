package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.ProductCategory;
import com.cobra.sell.repository.ProductCategoryRepository;
import com.cobra.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Baron
 * @Description: 商品类目Service实现
 * @Date: Created in 2019/1/7 1:10
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /**
     * 查询单个类目
     *
     * @param categoryId
     * @return
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.findOne(categoryId);
    }

    /**
     * 查询所有类目
     *
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    /**
     * 根据类目id查询类目
     *
     * @param categoryTypeList
     * @return
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    /**
     * 保存类目消息操作
     *
     * @param productCategory
     * @return
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
