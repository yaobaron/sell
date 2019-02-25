package com.cobra.sell.service.impl;

import com.cobra.sell.config.WechatAccountConfig;
import com.cobra.sell.dto.OrderDTO;
import com.cobra.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/1/17 5:26
 */
@Slf4j
@Service
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        //模板id
        templateMessage.setTemplateId(wechatAccountConfig.getTemplateId().get("orderStatus"));
        //发送给谁
        templateMessage.setToUser(orderDTO.getBuyerOpenid());
        //数据列表
        List<WxMpTemplateData> dataList = Arrays.asList(
                new WxMpTemplateData("first","亲请记得收货"),
                new WxMpTemplateData("keyword1","微信点餐"),
                new WxMpTemplateData("keyword2","18868812345"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5","￥"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","欢迎再次光临")
        );
        templateMessage.setData(dataList);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送异常，{}",e);
            e.printStackTrace();
        }
    }
}
