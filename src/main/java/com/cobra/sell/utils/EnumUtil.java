package com.cobra.sell.utils;

import com.cobra.sell.enums.CodeEnum;

/**
 * @Author: Baron
 * @Description: 枚举工具
 * @Date: Created in 2019/1/11 14:27
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
