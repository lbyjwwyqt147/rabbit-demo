package com.rabbit.example.consumer.service;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/***
 *  消费者接收消息
 */
@Log
@Component
public class HelloReceiver {

    /**
     *  接收消息
     *
     *  @param  msg
     *
     */
    @RabbitListener(queues = "helloQueue")
    public void process(String msg) {
        log.info("我是消费者1 消费队列 helloQueue 中的消息：" + msg);
    }
}
