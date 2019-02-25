package com.cobra.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Baron
 * @Description: 商品详情
 * @Date: Created in 2019/1/7 11:09
 */
@Data
public class ProductInfoVO implements Serializable {
    /**
     *  implements Serializable 快捷键添加shif+ctrl+s
     */
    private static final long serialVersionUID = -259670499210797950L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
