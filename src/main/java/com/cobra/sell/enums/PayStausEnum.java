package com.cobra.sell.enums;

import lombok.Getter;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 12:56
 */
@Getter
public enum PayStausEnum implements CodeEnum{
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStausEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
