package com.cobra.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 9:21
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /**
     * 主键id
     */
    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图片链接
     */
    private String productIcon;

    /**
     * 商品状态，0正常，1下架.
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;

}
