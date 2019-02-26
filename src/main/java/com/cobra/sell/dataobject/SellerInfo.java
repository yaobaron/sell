package com.cobra.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: Baron
 * @Description: 商家信息
 * @Date: Created in 2019/1/13 20:18
 */
@Data
@DynamicUpdate
@Entity
public class SellerInfo {

    /**
     * id
     */
    @Id
    private String sellerId;

    /**
     * 卖家姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
