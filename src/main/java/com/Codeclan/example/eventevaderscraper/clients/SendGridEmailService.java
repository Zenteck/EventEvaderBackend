package com.Codeclan.example.eventevaderscraper.clients;

import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.models.User;
import com.Codeclan.example.eventevaderscraper.payloads.Email;
import com.Codeclan.example.eventevaderscraper.repositories.UserRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
    @Service
    public class SendGridEmailService {

    @Value("${sendgrid.api-key}")
    String apiKey;

    @Value("${sendgrid.from-email}")
    String fromEmail;

    @Autowired
    UserRepository userRepository;

    protected Content contentOfEmail(Email email) {
        if (email.getTextBody() != null) {
            return new Content("text/plain", email.getTextBody());
        }
        if (email.getHtmlBody() != null) {
            return new Content("text/html", email.getHtmlBody());
        }
        return null;
    }

    public void send(Email email) {
        Personalization personalization = new Personalization();
        personalization.setSubject(email.getSubject());
        com.sendgrid.helpers.mail.objects.Email to = new com.sendgrid.helpers.mail.objects.Email(email.getRecipient());
        personalization.addTo(to);
        if (email.getCc() != null) {
            for (String cc : email.getCc()) {
                com.sendgrid.helpers.mail.objects.Email ccEmail = new com.sendgrid.helpers.mail.objects.Email();
                ccEmail.setEmail(cc);
                personalization.addCc(ccEmail);
            }
        }
        if (email.getBcc() != null) {
            for (String bcc : email.getBcc()) {
                com.sendgrid.helpers.mail.objects.Email bccEmail = new com.sendgrid.helpers.mail.objects.Email();
                bccEmail.setEmail(bcc);
                personalization.addBcc(bccEmail);
            }
        }
        Mail mail = new Mail();
//            mail.setTemplateId(email.getTemplateId());
        com.sendgrid.helpers.mail.objects.Email from = new com.sendgrid.helpers.mail.objects.Email();
        from.setEmail(fromEmail);
        mail.setFrom(from);
        mail.addPersonalization(personalization);
        Content content = contentOfEmail(email);
        mail.addContent(content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            for (String key : response.getHeaders().keySet()) {
                String value = response.getHeaders().get(key);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Email makeEmailForUser(User user) {
        Email email = new Email();

        List<Event> usersEvents = user.getEvents();

        String htmlListOfEvents = "<ul>";

        for (Event event: usersEvents) {
            htmlListOfEvents += "<li>" + event.getTitle() + ": on" + event.getStartTime().toString() + "</li>";
        }

        htmlListOfEvents += "</ul>";

        email.setRecipient(user.getEmailAddress());
        email.setRecipientFirstName("Azhar");
        email.setRecipientLastName("Sharif");
        email.setReplyTo("eventsevaderapp@gmail.com");
        email.setSubject("Upcoming Events");
        email.setHtmlBody("<h1>Greetings Lord Evader</h1>" +
                "<p>Here is a list of upcoming events</p>"+
                "<ul>" + htmlListOfEvents + "</ul>");

        return email;
    }



    public void sendAllEmails() {

        List<User> allUsers = userRepository.findAll();

        for (User user : allUsers) {
            Email usersEmail = makeEmailForUser(user);
            send(usersEmail);
        }
    }



}

