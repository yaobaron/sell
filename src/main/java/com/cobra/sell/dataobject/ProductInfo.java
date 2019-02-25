package com.cobra.sell.dataobject;

import com.cobra.sell.enums.PayStausEnum;
import com.cobra.sell.enums.ProductStatusEnum;
import com.cobra.sell.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 9:21
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -2811175632366779387L;


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
     * 商品状态，0在售，1下架,新增的商品默认为下架
     */
    private Integer productStatus=ProductStatusEnum.DOWN.getCode();

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间(方便排序)
     */
    private Date createTime;

    /**
     * 更新时间(方便排序)
     */
    private Date updateTime;

    @JsonInclude
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
