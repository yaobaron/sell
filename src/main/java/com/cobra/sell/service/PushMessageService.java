package com.cobra.sell.service;

import com.cobra.sell.dto.OrderDTO;

/**
 * @Author: Baron
 * @Description: 信息推送
 * @Date: Created in 2019/1/17 5:25
 */
public interface PushMessageService {

    /**
     * 订单状态变更
     *
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
