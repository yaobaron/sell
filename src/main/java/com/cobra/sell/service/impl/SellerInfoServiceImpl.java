package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.SellerInfo;
import com.cobra.sell.repository.SellerInfoRepository;
import com.cobra.sell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/13 22:03
 */
@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
