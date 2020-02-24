package com.Codeclan.example.eventevaderscraper;

import org.springframework.scheduling.annotation.Scheduled;

public class TestRunnable {

    public TestRunnable() {
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void run(){
        System.out.println("Scheduler is Running");
    }


}
