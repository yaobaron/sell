package com.cobra.sell.enums;

import lombok.Getter;

/**
 * @Author: Baron
 * @Description: 订单状态
 * @Date: Created in 2019/1/9 12:47
 */
@Getter
public enum OrderStausEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "已完结"),
    CANCEL(2, "已取消"),;
    private Integer code;

    private String message;

    OrderStausEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /*public static OrderStausEnum getOrderStausEnum(Integer code) {
        for (OrderStausEnum orderStausEnum: OrderStausEnum.values()) {
            if (orderStausEnum.getCode().equals(code)) {
                return orderStausEnum;
            }
        }
        return null;
    }*/
}
