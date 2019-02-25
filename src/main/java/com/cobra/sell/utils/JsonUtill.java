package com.cobra.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/15 14:09
 */
public class JsonUtill {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
