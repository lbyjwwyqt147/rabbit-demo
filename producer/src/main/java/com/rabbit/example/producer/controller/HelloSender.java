package com.rabbit.example.producer.controller;


import com.rabbit.example.producer.service.HelloSendService;
import com.rabbit.example.producer.service.HiSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  hello 发送消息
 */
@RestController
public class HelloSender {

    @Autowired
    HelloSendService helloSendService;
    @Autowired
    HiSendService hiSendService;

    /**
     * 发送消息
     */
    @PostMapping("/send/hello")
    public void send() {
        hiSendService.send();
        helloSendService.send();
    }
}
