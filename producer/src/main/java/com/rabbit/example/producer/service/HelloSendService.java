package com.rabbit.example.producer.service;

import lombok.extern.java.Log;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 *
 */
@Component
@Log
public class HelloSendService {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     *  向队列发消息
     */
    public void  send() {
        String sendMsg = " 我是俏如来 使用默认交换机Direct　发送消息 ................. ";
        // 使用默认交换机　Direct　发送信息
        this.amqpTemplate.convertAndSend("helloQueue", sendMsg);
    }

}
