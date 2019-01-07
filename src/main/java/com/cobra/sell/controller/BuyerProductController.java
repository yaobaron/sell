package com.cobra.sell.controller;

import com.cobra.sell.dataobject.ProductCategory;
import com.cobra.sell.dataobject.ProductInfo;
import com.cobra.sell.service.ProductCatetoryService;
import com.cobra.sell.service.ProductInfoService;
import com.cobra.sell.vo.ProductInfoVO;
import com.cobra.sell.vo.ProductVO;
import com.cobra.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 10:48
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCatetoryService productCatetoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfolist = productInfoService.findUpAll();
        //2.查询类目（一次性查询）

        //传统方法
        /*List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo:productInfolist) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //java8，lambda
        List<Integer> categoryTypeList = productInfolist.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        System.out.println(categoryTypeList.toString());
        List<ProductCategory> productCategoryList = productCatetoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            for (ProductInfo productInfo: productInfolist) {
                if(productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOlist(productInfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

}
