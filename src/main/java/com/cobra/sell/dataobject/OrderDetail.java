package com.cobra.sell.dataobject;

import javax.persistence.Id;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 12:49
 */
public class OrderDetail {

    @Id
    private  String detailId;
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
    private String productPrice;
    /**
     * 商品数量
     */
    private String productQuantity;
    /**
     * 商品小图
     */
    private String productIcon;

}
