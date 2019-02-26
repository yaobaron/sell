package com.cobra.sell.repository;

import com.cobra.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Baron
 * @Description: 商户信息Repository（dao）
 * @Date: Created in 2019/1/13 21:40
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    /**
     * 通过openid查
     *
     * @param openid
     * @return
     */
    SellerInfo findByOpenid(String openid);

}