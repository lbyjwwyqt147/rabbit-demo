package com.rabbit.example.producer.service.callback;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/***
 * 　消息被消费后　回调方法
 */
@Log
@Component
public class CallBackSenderService implements RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 发送消息  消费方收到确认后   会自动调confirm 方法
     */
    public void send(){
        rabbitTemplate.setConfirmCallback(this);
        String msg = "我发送的消息被消费后，我需要知道是否成功，所以你要回调确认.";
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg, correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info(" 回调确认：" + correlationData.getId());
    }
}
