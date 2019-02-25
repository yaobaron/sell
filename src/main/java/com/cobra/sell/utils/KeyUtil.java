package com.cobra.sell.utils;

import java.util.Random;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 14:49
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) +100000;
        return System.currentTimeMillis()+ String.valueOf(number);
    }
}
