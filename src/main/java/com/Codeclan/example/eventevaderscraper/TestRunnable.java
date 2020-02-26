package com.Codeclan.example.eventevaderscraper;

import com.Codeclan.example.eventevaderscraper.models.Event;
import org.springframework.scheduling.annotation.Scheduled;

public class TestRunnable {

    public static void main(String[] args) {
        Event event = new Event();
        event.printsHello();
    }


}
