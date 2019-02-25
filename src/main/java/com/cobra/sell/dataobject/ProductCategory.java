package com.cobra.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/6 21:46
 */
//@Table(name="??表明??")
@Entity
@Data
//@Getter
@DynamicUpdate//动态更新时间生效需要有改动
public class ProductCategory {

    /**
     * 类目id.
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名称.
     */
    private String categoryName;

    /**
     * 类目编码.
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

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
