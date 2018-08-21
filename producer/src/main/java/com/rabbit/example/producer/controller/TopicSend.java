package com.rabbit.example.producer.controller;

import com.rabbit.example.producer.service.topic.TopicSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * topic 发送
 */
@RestController
public class TopicSend {

    @Autowired
    TopicSendService topicSendService;

    /**
     *
     */
    @GetMapping("/topic/send")
    public void send(){
        topicSendService.send();
    }
}
