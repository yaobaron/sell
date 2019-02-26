package com.cobra.sell.service;

import com.cobra.sell.dataobject.SellerInfo;

/**
 * @Author: Baron
 * @Description: 查询商家信息Service
 * @Date: Created in 2019/1/13 21:56
 */
public interface SellerInfoService {

    /**
     * openid查卖家信息
     *
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

}
