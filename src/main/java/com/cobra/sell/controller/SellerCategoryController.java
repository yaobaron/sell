package com.cobra.sell.controller;

import com.cobra.sell.controller.form.CategoryForm;
import com.cobra.sell.dataobject.ProductCategory;
import com.cobra.sell.enums.ResultEnum;
import com.cobra.sell.exception.SellException;
import com.cobra.sell.service.ProductCategoryService;
import com.cobra.sell.utils.KeyUtil;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/13 17:50
 */
@Controller
@RequestMapping("/seller/category")
@Slf4j
public class SellerCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("productCategoryList",productCategoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     *
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory productCategory = productCategoryService.findOne(categoryId);
            map.put("productCategory", productCategory);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * 保存类目
     * @param categoryForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView index(@Valid CategoryForm categoryForm, BindingResult bindingResult,
                              Map<String, Object> map){
        map.put("url","/sell/seller/category/list");
        if (bindingResult.hasErrors()) {
            log.error("【卖家保存类目】，参数绑定，传参有误，error={}"+bindingResult.getFieldError().getDefaultMessage());
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("common/error",map);
        }
        ProductCategory productCategory = new ProductCategory();
        try {
            if (categoryForm.getCategoryId() != null) {
                productCategory = productCategoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, productCategory);
            productCategoryService.save(productCategory);
        } catch (SellException e) {
            log.error("【卖家保存类目】，发生错误，error={}", e.getMessage());
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        } catch (DataAccessException e1) {
            log.error("【卖家保存类目】，类目类型发生错误，error={}", e1.getMessage());
            map.put("msg", "类目类型跟其他有重复");
            return new ModelAndView("common/error", map);
        }
        return new ModelAndView("common/success",map);
    }
}
