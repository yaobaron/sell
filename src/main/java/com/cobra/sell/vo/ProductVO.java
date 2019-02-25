package com.cobra.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Baron
 * @Description:商品（包含类目信息）
 * @Date: Created in 2019/1/7 11:03
 */
@Data
public class ProductVO  implements Serializable {

    private static final long serialVersionUID = -6573652182706375937L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOlist;
}
