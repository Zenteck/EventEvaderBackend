package com.Codeclan.example.eventevaderscraper.clients;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailClient {

    public static void sendMail(String recipient) throws Exception{
        System.out.println("Preparing to send an email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host", "smpt.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = "evenstevaderapp@gmail.com";
        String myPassword = "azhar-1code-2";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, myPassword);
            }
        });

        Message message= prepareMessage(session, myAccountEmail, recipient);

        Transport.send(message);
        System.out.println("Message sent successfully");

    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress((recipient)));
            message.setSubject("EventsEvader Notification");
            message.setText("Hey there evader, \n Here are a list of events in the coming week you may want to avoid ");
        } catch (Exception ex) {
            Logger.getLogger(EmailClient.class.getName()).log(Level.SEVERE, null, ex);
        };
        return null;
    }

}
