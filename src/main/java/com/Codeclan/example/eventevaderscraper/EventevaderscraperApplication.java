package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.clients.SendGridEmailService;
import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.payloads.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class EventevaderscraperApplication {

	SendGridEmailService sendGridEmailService;

	public static void main(String[] args) {
		SpringApplication.run(EventevaderscraperApplication.class, args);

	}




}
