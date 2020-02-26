package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.clients.SendGridEmailService;
import com.Codeclan.example.eventevaderscraper.payloads.Email;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    SendGridEmailService sendGridEmailService;


    @Test
    public void canSendEmail(){

        Email email = new Email();
        email.setRecipient("azhar981@gmail.com");
        email.setRecipientFirstName("Azhar");
        email.setRecipientLastName("Sharif");
        email.setReplyTo("eventsevaderapp@gmail.com");
        email.setSubject("Event evader test ");
        email.setHtmlBody("<h1> Test Email</h1>");
        sendGridEmailService.send(email);
    }
}
