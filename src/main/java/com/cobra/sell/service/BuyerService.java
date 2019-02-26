package com.cobra.sell.service;

import com.cobra.sell.dto.OrderDTO;

/**
 * @Author: Baron
 * @Description: 买家专属订单服务
 * @Date: Created in 2019/1/10 23:23
 */
public interface BuyerService {

    /**
     * 查询一个订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);

}
