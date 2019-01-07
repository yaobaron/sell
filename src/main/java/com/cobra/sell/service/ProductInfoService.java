package com.cobra.sell.service;

import com.cobra.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Baron
 * @Description: 商品service
 * @Date: Created in 2019/1/7 9:59
 */
public interface ProductInfoService {

    /**
     * 用id找商品
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 商家管理后台获取商品分页
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 查询所有上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 保存和修改
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    //增加库存

    //减少库存
}
