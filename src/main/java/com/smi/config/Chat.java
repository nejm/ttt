/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smi.config;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class Chat {
    
    private Session mySession;
    
    @OnMessage
    public void onMessage(String message,Session session) throws IOException,
            InterruptedException {
        System.out.println("User input: " + message+" : "+session.getUserPrincipal().getName());
       
    }

    @OnOpen
    public void onOpen(Session session) {
        mySession = session;
    }

    @OnClose
    public void onClose(Session session) {
        
    }
    
}
