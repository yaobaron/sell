package com.cobra.sell.service;

import com.cobra.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/15 3:18
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refound(OrderDTO orderDTO);
}
