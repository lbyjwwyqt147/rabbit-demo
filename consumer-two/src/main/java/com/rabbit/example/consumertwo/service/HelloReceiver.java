package com.rabbit.example.consumertwo.service;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/***
 * 接受　helloQuery 队列里消息
 */
@Log
@Component
public class HelloReceiver {

    /**
     * 消费消息
     * @param msg
     */
    @RabbitListener(queues = "helloQueue")
    public void  process(String msg) {
        log.info("hello 消费者2  接收到生产者发送的消息............................");
        log.info(msg);
    }


}
