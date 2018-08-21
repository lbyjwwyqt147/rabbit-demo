package com.rabbit.example.producer.service.topic;

import lombok.extern.java.Log;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 *  topic 方式发送消息
 */
@Log
@Component
public class TopicSendService {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     *
     */
    public  void  send() {
        String sendMsg = " 我是缺舟一晃度  使用交换机Topic　发送消息 ................. ";
        // 转发消息主要是根据通配符。 在这种交换机下，队列和交换机的绑定会定义一种路由模式，那么，通配符就要在这种路由模式和路由键之间匹配后交换机才能转发消息。
        //第一个参数表示交换机，第二个参数表示routing key，第三个参数即消息。
        // exchange　配置信息　对应　TopicRabbitConfig　类中　定义交换机
        this.amqpTemplate.convertAndSend("exchange", "topic.message", sendMsg);
    }
}
