package com.smi.config;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    public static void send(String receipt, String code) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.orange.tn");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");
        props.put("mail.smtp.port", "25");
 
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("51586958@orange.tn", "MN5RUP1Y");
            }
        });

        try { 
            MimeMessage  message = new MimeMessage(session);
            message.setFrom(new InternetAddress("51586958@orange.tn"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receipt));

            message.setSubject("Testing Subject");
            message.setContent("your code is <br> "+code,"text/html");
            Transport.send(message);
            System.out.println("sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
