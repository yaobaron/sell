package com.cobra.sell.exception;

import com.cobra.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @Author: Baron
 * @Description: 普通业务异常
 * @Date: Created in 2019/1/9 14:24
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException() {
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
