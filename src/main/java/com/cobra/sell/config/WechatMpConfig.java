package com.cobra.sell.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: Baron
 * @Description: 微信公众号相关信息注入
 * @Date: Created in 2019/1/14 22:38
 */
@Component
public class WechatMpConfig {

    @Autowired()
    private WechatAccountConfig accountConfig;

    @Bean(autowire = Autowire.BY_NAME, name = "wxMpService")
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        String appId = accountConfig.getMpAppId();
        String mpAppSecret = accountConfig.getMpAppSecret();
        wxMpInMemoryConfigStorage.setAppId(appId);
        wxMpInMemoryConfigStorage.setSecret(mpAppSecret);
        return wxMpInMemoryConfigStorage;
    }
}
