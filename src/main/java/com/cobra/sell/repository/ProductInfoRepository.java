package com.cobra.sell.repository;

import com.cobra.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Baron
 * @Description: 商品信息Repository（dao）
 * @Date: Created in 2019/1/7 9:36
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 通过商品状态获取商品列表
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
