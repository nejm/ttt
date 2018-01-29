package com.smi.config;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@ServerEndpoint("/push")
public class Push {

    private static final Set<Session> SESSIONS = ConcurrentHashMap.newKeySet();

    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException,
            ParseException {
        JSONParser parser = new JSONParser();
        JSONObject o = (JSONObject) parser.parse(message);
        if (o.get("from").toString().equalsIgnoreCase(session.getUserPrincipal().getName()) && 
           !o.get("to").toString().equalsIgnoreCase(session.getUserPrincipal().getName())) {
            Push.sendTo(o.get("to").toString(), o.get("body").toString());
        }

    }

    @OnOpen
    public void onOpen(Session session) {
        SESSIONS.add(session);
        Push.sendAll("+"+session.getUserPrincipal().getName());
    }

    @OnClose
    public void onClose(Session session) {
        SESSIONS.remove(session);
        Push.sendAll("-"+session.getUserPrincipal().getName());
    }

    public static void sendAll(String text) {
        synchronized (SESSIONS) {
            for (Session session : SESSIONS) {
                if (session.isOpen()) {
                    session.getAsyncRemote().sendObject(text);
                }
            }
        }
    }

    public static void sendTo(String to, String msg) {
        for (Session session : SESSIONS) {
            if (session.isOpen() && session.getUserPrincipal().getName().equalsIgnoreCase(to)) {
                session.getAsyncRemote().sendText(msg);
            }
        }

    }

}
