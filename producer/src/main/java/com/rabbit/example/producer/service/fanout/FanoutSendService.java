package com.rabbit.example.producer.service.fanout;

import lombok.extern.java.Log;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * 广播 订阅方式发送消息
 */
@Log
@Component
public class FanoutSendService {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     *
     */
    public void send() {

        String sendMsg = " 我是大智慧  我使用交换机Fanout  广播无我梵音到九界各地 ................. ";
        // Fanout 模式 因为使用了A、B、C三个队列绑定到Fanout交换机上面，发送端的routing_key写任何字符都会被忽略(即传任何参数都视为无效)
        //第一个参数表示交换机，第二个参数表示routing key，第三个参数即消息。
        // fanoutExchange　配置信息　对应　FanoutRabbitConfig　类中　定义交换机
        this.amqpTemplate.convertAndSend("fanoutExchange", "", sendMsg);

    }
}
