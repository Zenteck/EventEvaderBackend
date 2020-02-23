package com.Codeclan.example.eventevaderscraper.components;


import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.models.User;
import com.Codeclan.example.eventevaderscraper.models.Venue;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import com.Codeclan.example.eventevaderscraper.repositories.UserRepository;
import com.Codeclan.example.eventevaderscraper.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VenueRepository venueRepository;

    public DataLoader(){

    }


    @Scheduled(cron = "0 0 9-21 * * *")
    public void run(ApplicationArguments args) {

        SimpleDateFormat apiDateFormat = new SimpleDateFormat("dd/mm") ;

        LocalDate today =  LocalDate.now();

        LocalDate tomorrow = today.now().plusDays(1);

        LocalDate next7Days = today.now().plusDays(7);


                Venue ibrox = new Venue("Ibrox");
        venueRepository.save(ibrox);

        Venue celtic = new Venue("Celtic Park");
        venueRepository.save(celtic);

        Venue hampden = new Venue("Hampden Park");
        venueRepository.save(hampden);


        Event football1 = new Event(today , "1500", "Rangers v Kilmarnock", ibrox);
        eventRepository.save(football1);

        Event football2 = new Event(today, "1900", "Celtic v Cally", celtic);
        eventRepository.save(football2);

//        Event rugby1 = new Event("24/02", "1200", "Scotland v Ireland", hampden);
//        eventRepository.save(rugby1);
//
//        Event rugby2 = new Event("01/03", "1315", "Scotland v Wales", hampden);
//        eventRepository.save(rugby2);

        Event football3 = new Event(tomorrow, "1600", "Celtic v Barcelona", celtic);
        eventRepository.save(football3);


        User alan = new User("apps+eventevader@zenteck.co.uk");
        alan.addVenue(celtic);
        alan.addEvent(football2);
        userRepository.save(alan);

        User azhar = new User("codeninja@codeclan.com");
        azhar.addVenue(ibrox);
        azhar.addVenue(hampden);
        azhar.addEvent(football1);
        userRepository.save(azhar);

        User elle = new User("plattsnpink@gmail.com");
        elle.addVenue(hampden);
//        elle.addEvent(rugby1);
//        elle.addEvent(rugby2);
        userRepository.save(elle);


    }


}
