package com.rabbit.example.consumer.service.fanout;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 广播订阅者C
 */
@Log
@Component
public class FanoutReceiverC {

    /***
     *
     * @param msg
     */
    @RabbitListener(queues = "fanout.C")
    public void process(String msg) {
        log.info("我是广播订阅者C  接收到发送方的广播消息：" + msg);
    }


}
