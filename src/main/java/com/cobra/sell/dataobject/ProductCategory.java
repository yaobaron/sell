package com.cobra.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    /** 信息创建时间 */
    //private Date create_time;

    /**
     * 信息修改时间
     */
    //private Date update_time;
    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
