package com.cobra.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Baron
 * @Description: 微信授权
 * @Date: Created in 2019/1/14 21:09
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法。。。。。。");
        log.info("code={}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=wx293a052e3fa3e4b0&secret=1ff31525a1a19140562a289ff79c8b58&code="
                + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("respose={}", response);
    }
}
