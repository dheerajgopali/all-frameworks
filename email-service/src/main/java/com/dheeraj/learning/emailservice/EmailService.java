package com.dheeraj.learning.emailservice;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by gopad on 28-09-2017.
 */
public class EmailService {

    public static void sendEmail(EmailServerData esd, EmailData ed){
        String to = "";//change accordingly
        String from = "DheerajKumar.Gopali@in.pega.com";//change accordingly

        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty(esd.getSmtpHostKey(),esd.getSmtpHostValue());
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ed.getFrom()));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(ed.getTo()));
            message.setSubject(ed.getSubject());
            message.setContent(ed.getText(), "text/html; charset=utf-8");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        }catch (MessagingException mex) {mex.printStackTrace();}
    }
}