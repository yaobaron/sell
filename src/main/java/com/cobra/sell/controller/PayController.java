package com.cobra.sell.controller;

import com.cobra.sell.dto.OrderDTO;
import com.cobra.sell.enums.ResultEnum;
import com.cobra.sell.exception.SellException;
import com.cobra.sell.service.OrderService;
import com.cobra.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/15 3:06
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @RequestMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map) {
        String returnUrlDecoder = "";
        try {
            returnUrlDecoder = URLDecoder.decode(returnUrl,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map.put("returnUrl",returnUrlDecoder);
        log.info("returnUrl={}",returnUrlDecoder);
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse",payResponse);
        //map.put("returnUrl",URLDecoder.decode(returnUrl));
        //log.info("returnUrl={}",URLDecoder.decode(returnUrl));
        return new ModelAndView("pay/create",map);
    }

    @PostMapping("notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);
        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
