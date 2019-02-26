package com.cobra.sell.constant;

/**
 * @Author: Baron
 * @Description: redis的常量
 * @Date: Created in 2019/1/17 2:28
 */
public interface RedisConstant {

    /**
     * 前缀
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 过期时间，两个小时
     */
    Integer EXPIRE = 7200;
}
