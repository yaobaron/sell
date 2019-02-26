package com.cobra.sell.repository;

import com.cobra.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Baron
 * @Description: 订单信息Repository（dao）
 * @Date: Created in 2019/1/9 13:04
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);

}
