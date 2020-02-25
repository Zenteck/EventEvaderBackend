package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.payloads.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Instant;
import java.util.concurrent.ScheduledFuture;


@SpringBootApplication
public class EventevaderscraperApplication {



	public static void main(String[] args) {

		SpringApplication.run(EventevaderscraperApplication.class, args);


	}





}
