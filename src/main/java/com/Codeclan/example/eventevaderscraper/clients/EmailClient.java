package com.Codeclan.example.eventevaderscraper.clients;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailClient {

    @Value("${app.sendgrid.key}")
    private String templateId;
    @Autowired
    SendGrid sendGrid;

    public String sendEmail(String email) throws IOException {
        Mail mail = prepareMail(email);

        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");

        try {
            request.setBody(mail.build());


            Response response = sendGrid.api(request);

            if (response != null) {
                System.out.println("response code form sendgrid" + response.getHeaders());
            }

        }

        catch (IOException e) {
            e.printStackTrace();
            return "error in sent";
        }

        return "mail has been sent check your inbox";

    }

    public Mail prepareMail(String email){
        Mail mail = new Mail();

        Email from = new Email();

        Email to = new Email();

        String subject = "SendGrid Test";

        Content content = new Content("text/plain", "Testing the email service");

        from.setEmail("eventsevaderapp@gmail.com");

        to.setEmail(email);

        Personalization personalization = new Personalization();

        personalization.addTo(to);

        mail.setTemplateId(templateId);

        return mail;

    }

}
