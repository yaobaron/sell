package com.cobra.sell.service;

import com.cobra.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author: Baron
 * @Description: 类目Service
 * @Date: Created in 2019/1/7 0:58
 */
public interface ProductCategoryService {
    /**
     * 通过类目id查找类目
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 获取所有类目
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过类目类型list查询类目list
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存和修改类目
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);

}
