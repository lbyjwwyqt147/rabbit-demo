package com.rabbit.example.consumer.service.fanout;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 广播订阅者B
 */
@Log
@Component
public class FanoutReceiverB {

    /***
     *
     * @param msg
     */
    @RabbitListener(queues = "fanout.B")
    public void process(String msg) {
        log.info("我是广播订阅者B  接收到发送方的广播消息：" + msg);
    }


}
