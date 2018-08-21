package com.rabbit.example.producer.service;

import lombok.extern.java.Log;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 *
 */
@Log
@Component
public class HiSendService {
    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     *  向队列发消息
     */
    public void  send() {
        String sendMsg = " 我是默苍离 我是生产者负责创建消息发送到helloQuery ................. ";
        this.amqpTemplate.convertAndSend("helloQueue", sendMsg);
    }
}
