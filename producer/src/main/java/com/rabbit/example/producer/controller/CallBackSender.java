package com.rabbit.example.producer.controller;

import com.rabbit.example.producer.service.callback.CallBackSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 */
@RestController
public class CallBackSender {

    @Autowired
    CallBackSenderService callBackSenderService;

    /**
     *
     */
    @GetMapping("/callback/send")
    public void send(){
        callBackSenderService.send();
    }
}
