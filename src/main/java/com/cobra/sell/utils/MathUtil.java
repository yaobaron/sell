package com.cobra.sell.utils;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/16 10:21
 */
public class MathUtil {
    private static final Double MONEY_RANGE = 0.01;
    public static Boolean equals(Double d1, Double d2) {
        Double reuslt = Math.abs(d1-d2);
        if (reuslt < MONEY_RANGE) {
            return true;
        }else {
            return false;
        }
    }
}
