package com.cobra.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 12:39
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;
    /**
     * 买家名字
     */
    private  String buyerName;
    /**
     * 买家电话
     */
    private  String buyerPhone;
    /**
     * 买家地址
     */
    private  String buyerAddress;
    /**
     * 买家微信openid
     */
    private  String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认0新下单
     */
    private Integer orderStatus;
    /**
     * 支付状态，默认0未支付
     */
    private Integer payStatus;

}
