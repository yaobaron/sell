package com.cobra.sell.dto;

import lombok.Data;

/**
 * @Author: Baron
 * @Description: 购物车
 * @Date: Created in 2019/1/9 15:35
 */
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
