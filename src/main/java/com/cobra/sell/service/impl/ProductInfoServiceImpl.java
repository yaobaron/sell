package com.cobra.sell.service.impl;

import com.cobra.sell.dataobject.ProductInfo;
import com.cobra.sell.dto.CartDTO;
import com.cobra.sell.enums.PayStausEnum;
import com.cobra.sell.enums.ProductStatusEnum;
import com.cobra.sell.enums.ResultEnum;
import com.cobra.sell.exception.SellException;
import com.cobra.sell.repository.ProductInfoRepository;
import com.cobra.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/7 10:07
 */
@Service
//@CacheConfig(cacheNames = "product")方法中的cacheNames参数可以不写
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    //@Cacheable(cacheNames = "product",key = "123")查询缓存，key去掉默认为空，用入参来代替
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    //@CachePut(cacheNames = "product",key = "123")修改之后缓存，返回类型需要一样，一般与@Cacheable结合使用
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO carDTO: cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(carDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - carDTO.getProductQuantity();
            if (result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoRepository.findOne(productId);
        if (productInfo==null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum()==ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoRepository.findOne(productId);
        if (productInfo==null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum()==ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoRepository.save(productInfo);
    }
}
