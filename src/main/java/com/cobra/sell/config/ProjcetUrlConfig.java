package com.cobra.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/17 1:25
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjcetUrlConfig {

    /**
     * 微信公众平台授权url
     */
    private String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    private String wechatOpenAuthorize;

    /**
     * 点餐系统网址
     */
    private String sell;
}
