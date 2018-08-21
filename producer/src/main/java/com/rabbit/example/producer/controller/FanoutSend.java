package com.rabbit.example.producer.controller;

import com.rabbit.example.producer.service.fanout.FanoutSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 广播
 */
@RestController
public class FanoutSend {

    @Autowired
    FanoutSendService fanoutSendService;

    /**
     *
     */
    @GetMapping("fanout/send")
    public void send(){
        fanoutSendService.send();
    }
}
