package com.cobra.sell.repository;

import com.cobra.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Baron
 * @Description: 商品类别Repository（dao）
 * @Date: Created in 2019/1/6 22:04
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 通过类目类型的list查询类目信息
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
