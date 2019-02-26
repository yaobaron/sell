package com.cobra.sell.controller.form;

import lombok.Data;

/**
 * @Author: Baron
 * @Description: 前端传入类目信息数据绑定
 * @Date: Created in 2019/1/13 18:57
 */
@Data
public class CategoryForm {

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 类目名称.
     */
    private String categoryName;

    /**
     * 类目编码.
     */
    private Integer categoryType;
}
