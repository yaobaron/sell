package com.cobra.sell.handler;

import com.cobra.sell.config.ProjcetUrlConfig;
import com.cobra.sell.exception.ResponseBankException;
import com.cobra.sell.exception.SellException;
import com.cobra.sell.exception.SellerAuthorizeException;
import com.cobra.sell.utils.ResultVOUtil;
import com.cobra.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/17 4:42
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjcetUrlConfig projcetUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        //借用账号的的方式，直接写死
        return new ModelAndView("redirect:".concat("https://open.weixin.qq.com/connect/qrconnect?" +
                "appid=wx6ad144e54af67d87&" +
                "redirect_uri=http%3A%2F%2Fsell.springboot.cn%2Fsell%2Fqr%2FoTgZpwRxqIBnfgeTfOLeXbK7EttE&" +
                "response_type=code&" +
                "scope=snsapi_login&" +
                "state=http%3a%2f%2fyaostore.natapp1.cc%2fsell%2fwechat%2fqrUserInfo"));
        //真实中是以url拼接方式
        //return new ModelAndView("redirect:".concat(projcetUrlConfig.getSell().concat("")));
    }

    /**
     * 捕获SellException，返回规范错误信息
     * @param e
     * @return
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e) {
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    /**
     * 返回带有相应码的错误信息，加上@ResponseStatus(HttpStatus.FORBIDDEN)
     */
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException() {

    }

}
