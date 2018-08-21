package com.rabbit.example.producer.service.callback;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/***
 * 　发送方确认模式 发消息
 */
@Log
@Component
public class CallBackSenderService implements RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 发送方确认模式 发消息
     */
    public void send(){
        rabbitTemplate.setConfirmCallback(this);
        String msg = "我发送的消息被消费后，我需要知道是否成功，所以你要回调确认.";
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg, correlationData);
    }

    /**
     * 消息确认
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info(" 消息确认标识消息ID：" + correlationData.getId());
    }
}
