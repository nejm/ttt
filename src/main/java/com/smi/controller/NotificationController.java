package com.smi.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(JSONObject message) throws Exception {
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkk");
        return new String(message.get("name") + " has logged in !");
    }

    @RequestMapping(value = "/simMessage")
    public String greeting() throws Exception {
        template.convertAndSend("/topic/greetings",
                new String("Hello, Other!"));
        return "sample";
    }
}
