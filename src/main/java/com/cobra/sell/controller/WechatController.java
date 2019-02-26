package com.cobra.sell.controller;

import com.cobra.sell.config.ProjcetUrlConfig;
import com.cobra.sell.enums.ResultEnum;
import com.cobra.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: Baron
 * @Description: 微信授权，获取openid等
 * @Date: Created in 2019/1/14 22:33
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Qualifier("wxMpService")
    @Autowired
    private WxMpService wxMpService;

    @Qualifier("wxOpenservice")
    @Autowired
    private WxMpService wxOpenservice;

    @Autowired
    private ProjcetUrlConfig projcetUrlConfig;

    /**
     * 授权
     *
     * @param returnUrl
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        //1.配置
        //2.调用方法
        String url = projcetUrlConfig.getWechatMpAuthorize() + "/sell/wechat/userInfo";
        String returnUrlEncoder = "";
        try {
            returnUrlEncoder = URLEncoder.encode(returnUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("【微信网络授权】，encode解析returnUrl错误：returnUrl={}", returnUrl);
            e.printStackTrace();
        }
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, returnUrlEncoder);
        log.info("returnUrl={},URLEncoder.encode(returnUrl)={}", returnUrl, redirectUrl);
        return "redirect:" + redirectUrl;
    }

    /**
     * 获取信息
     *
     * @param code
     * @param returnUrl
     * @return
     */
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网络授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("openId={}", openId);
        return "redirect:" + returnUrl + "?openid=" + openId;
    }

    /**
     * 正常流程登录时访问这个地址，带扫码后跳转的url
     *
     * @param returnUrl
     * @return
     */
    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projcetUrlConfig.getWechatOpenAuthorize() + "/sell/weChat/qrUserInfo";
        String returnUrlEncoder = "";
        try {
            returnUrlEncoder = URLEncoder.encode(returnUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("【微信网页授权】，encode解析returnUrl错误：returnUrl={}", returnUrl);
            e.printStackTrace();
        }
        String redirectUrl = wxOpenservice.buildQrConnectUrl(url,
                WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN, returnUrlEncoder);
        return "redirect:" + redirectUrl;
    }

    /**
     * 正常流程获取openid的方法
     */
    /**
     @GetMapping("/qrUserInfo") public String qrUserInfo(@RequestParam("code") String code,
     @RequestParam("returnUrl") String returnUrl){
     WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
     try {
     wxMpOAuth2AccessToken = wxOpenservice.oauth2getAccessToken(code);
     } catch (WxErrorException e) {
     log.error("【微信网页授权】，{}",e);
     throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
     }
     log.info("wxMpOAuth2AccessToken={}",wxMpOAuth2AccessToken);
     String openId = wxMpOAuth2AccessToken.getOpenId();
     log.info("【微信扫码登录】接收到的openId={}",openId);
     return "redirect:" +returnUrl+"?openid="+openId;
     }
     */

    /**
     * 借用开放平台账号的获取登录openid方法
     *
     * @param code
     * @return
     */
    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code) {
        //借用开放平台账号先把url写死
        String returnUrl = "http://yaostore.natapp1.cc/sell/seller/login";
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenservice.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】，{}=", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("【微信扫码登录】接收到的openId={}", openId);
        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}