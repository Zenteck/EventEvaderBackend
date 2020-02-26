package com.Codeclan.example.eventevaderscraper.components;


import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.models.User;
import com.Codeclan.example.eventevaderscraper.models.Venue;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import com.Codeclan.example.eventevaderscraper.repositories.UserRepository;
import com.Codeclan.example.eventevaderscraper.repositories.VenueRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    TheListReader theListReader;


    public DataLoader(){

    }


    @Scheduled(cron = "0 0 9-21 * * *")
    public void run(ApplicationArguments args) throws JsonProcessingException {

        userRepository.deleteAll();
        eventRepository.deleteAll();
        venueRepository.deleteAll();



        //Creating dates
//        LocalDate dateToday =  LocalDate.now();
//
//        LocalDate dateTomorrow = dateToday.now().plusDays(1);
//
//        LocalDate dateIn7Days = dateToday.now().plusDays(7);
//
//        LocalDate dateIn8Days = dateToday.now().plusDays(8);
//
//        LocalDate dateIn30Days = dateToday.now().plusDays(30);
//
//        LocalDate dateIn34Days = dateToday.plusDays(34);


        //Creating venues
        Venue ibrox = new Venue("Ibrox Stadium", "9a37fbc9-19e0-892b-f58b-c6f40000aaa5");
        venueRepository.save(ibrox);

        Venue celtic = new Venue("Celtic Park", "b940eadd-4f1e-b60e-85e0-bcc40000356f");
        venueRepository.save(celtic);

        Venue hampden = new Venue("Hampden Park", "2c9fdadd-4f1e-b60e-33e0-bcc400002a94");
        venueRepository.save(hampden);

        Venue murrayfield = new Venue("Murrayfield", "938fdadd-4f1e-b60e-03e0-bcc400002719");
        venueRepository.save(murrayfield);


        theListReader.getEvents();

        List<Event> events = eventRepository.findAll();
        Event azharEvent1 = events.get(0);
        Event alanEvent1 = events.get(1);


        List <Venue> venues = venueRepository.findAll();
        Venue azharVenue = venues.get(0);
        Venue alanVenue = venues.get(1);

//
        User alan = new User("spambox@zenteck.co.uk");
//        alan.addVenue(celtic);
        alan.addEvent(alanEvent1);
        alan.addVenue(alanVenue);
        userRepository.save(alan);

        User azhar = new User("azhar981@outlook.com");
//        azhar.addVenue(ibrox);
//        azhar.addVenue(hampden);
        azhar.addEvent(azharEvent1);
        azhar.addVenue(azharVenue);
        userRepository.save(azhar);

        User eleanor = new User("cassona@hotmail.com");
//        eleanor.addVenue(hampden);
//        eleanor.addEvent(rugby1);
//        eleanor.addEvent(rugby2);
        userRepository.save(eleanor);

    }


}
