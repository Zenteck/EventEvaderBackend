package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.clients.EventClient;
import com.Codeclan.example.eventevaderscraper.clients.SendGridEmailService;
import com.Codeclan.example.eventevaderscraper.payloads.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class EventevaderscraperApplicationTests {


	@Autowired
	EventClient eventClient;

	@Test
	void contextLoads() {
	}

	@Test
	void canGetStringBack(){
		ResponseEntity<String> response = eventClient.requestEvents();
		System.out.println("hi");
		System.out.println(response);


	}

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
