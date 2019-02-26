package com.cobra.sell.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Baron
 * @Description: http返回的最外层对象
 * @Date: Created in 2019/1/7 10:54
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -9008051287947584245L;

    /**
     * 返回信息码，错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回具体对象
     */
    private T data;

}
