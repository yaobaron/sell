package com.cobra.sell.enums;

import lombok.Getter;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 14:25
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_ERROR(17,"订单支付状态不正确"),
    CART_EMPTY(18,"购物车为空"),
    ORDER_OWNER_ERROR(19,"订单不属于当前用户"),
    ORDER_CNACEL_SUCCESS(20,"取消订单成功！"),
    ORDER_FINISH_SUCCESS(20,"完结订单成功！"),
    PRODUCT_STATUS_ERROR(21,"产品状态不正确！"),
    PRODUCT_OFFSALE_SUCCESS(22,"商品下架成功！"),
    PRODUCT_ONSALE_SUCCESS(23,"商品上架成功！"),
    PRODUCT_UPDATA_SUCCESS(24,"商品修改成功！"),
    WECHAT_MP_ERROR(25,"微信公众账号方面错误！"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(26,"微信支付金额校验错误！"),
    LOGIN_FAIL(27,"登录失败，登录信息不正确"),
    LOGOUT_SUCCESS(28,"登出成功"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
