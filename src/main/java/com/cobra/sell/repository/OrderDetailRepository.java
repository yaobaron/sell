package com.cobra.sell.repository;

import com.cobra.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/9 13:10
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);

}
