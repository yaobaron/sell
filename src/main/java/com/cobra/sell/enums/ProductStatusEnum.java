package com.cobra.sell.enums;

import lombok.Getter;

/**
 * @Author: Baron
 * @Description: 商品状态
 * @Date: Created in 2019/1/7 10:13
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在售"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String status;

    ProductStatusEnum(Integer code,String status) {
        this.code = code;
        this.status = status;
    }
}
