/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smi.controller;

import com.smi.model.Notification;
import java.security.Principal;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
