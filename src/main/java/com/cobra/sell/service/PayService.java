package com.cobra.sell.service;

import com.cobra.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @Author: Baron
 * @Description: 支付Service
 * @Date: Created in 2019/1/15 3:18
 */
public interface PayService {

    /**
     * 发起支付
     *
     * @param orderDTO
     * @return
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 异步通知
     *
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);

    /**
     * 退款
     *
     * @param orderDTO
     * @return
     */
    RefundResponse refound(OrderDTO orderDTO);

}
