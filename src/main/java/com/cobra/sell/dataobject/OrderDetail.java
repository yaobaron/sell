package com.cobra.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: Baron
 * @Description: 订单详情
 * @Date: Created in 2019/1/7 12:49
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 产品号
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
     * 商品数量
     */
    private Integer productQuantity;
    /**
     * 商品小图
     */
    private String productIcon;

}
