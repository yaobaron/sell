package com.cobra.sell.controller.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/12 19:24
 */
@Data
public class ProductForm {
    /**
     * 主键id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图片链接
     */
    private String productIcon;

    /**
     * 类目编号
     */
    private Integer categoryType;

}
