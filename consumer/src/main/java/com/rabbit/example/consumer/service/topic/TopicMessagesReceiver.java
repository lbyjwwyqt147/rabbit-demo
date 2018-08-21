package com.rabbit.example.consumer.service.topic;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/***
 * topic
 */
@Component
@Log
public class TopicMessagesReceiver {

    /**
     *  接收消息 只能监听队列完全匹配“topic.message”
     *
     *  @param msg
     *
     */
    @RabbitListener(queues = "topic.messages")
    public void process(String msg) {
        log.info("我是消费者1 消费队列 topic.messages 中的消息：" + msg);
    }


}
