package com.cobra.sell.aspect;

import com.cobra.sell.constant.CookieConstant;
import com.cobra.sell.constant.RedisConstant;
import com.cobra.sell.exception.SellerAuthorizeException;
import com.cobra.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/17 4:12
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.cobra.sell.controller.Seller*.*(..))" +
    "&& !execution(public * com.cobra.sell.controller.SellerUserController.*(..))")
    public void verify(){

    }

    @Before("verify()")
    public void doVerify(){
//
//        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        HttpServletResponse response = attributes.getResponse();
//        //查询浏览器中cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie==null) {
//            log.warn("【登录校验】 Cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//        //去redis里查询
//        String tokenValue = redisTemplate.opsForValue().get(
//                String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//        if (StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登录校验】 Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
//        //更新redis、cookie里的时间，重新设置为7200
//        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()),tokenValue,
//                CookieConstant.EXPIRE,TimeUnit.SECONDS);
//        CookieUtil.set(response, CookieConstant.TOKEN, cookie.getValue(), CookieConstant.EXPIRE);

    }
}
