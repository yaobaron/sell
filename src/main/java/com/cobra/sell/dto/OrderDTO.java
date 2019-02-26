package com.cobra.sell.dto;

import com.cobra.sell.dataobject.OrderDetail;
import com.cobra.sell.enums.OrderStausEnum;
import com.cobra.sell.enums.PayStausEnum;
import com.cobra.sell.utils.EnumUtil;
import com.cobra.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Baron
 * @Description: 订单DTO
 * @Date: Created in 2019/1/9 13:36
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信openid
     */
    private String buyerOpenid;
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
    /**
     * 创建时间(方便排序)
     */
    @JsonSerialize(using = Date2LongSerializer.class) //以秒输出给前端
    private Date createTime;
    /**
     * 更新时间(方便排序)
     */
    @JsonSerialize(using = Date2LongSerializer.class) //以毫秒输出给前端
    private Date updateTime;

    /**
     * 订单包含的商品详细信息；
     * 如果前端需要必须返回，又不能为null，则赋予初始值
     */
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    //加上@JsonInclude，对象转Json会忽略掉这个方法
    @JsonInclude
    public OrderStausEnum getOrderStatusEnum() {
        //return OrderStausEnum.getOrderStausEnum(orderStatus);
        return EnumUtil.getByCode(orderStatus, OrderStausEnum.class);
    }

    @JsonInclude
    public PayStausEnum getPayStatausEnum() {
        return EnumUtil.getByCode(payStatus, PayStausEnum.class);
    }
}
