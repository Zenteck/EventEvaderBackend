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
        userRepository.deleteAll();
        eventRepository.deleteAll();
        venueRepository.deleteAll();



        //Creating dates
        LocalDate dateToday =  LocalDate.now();

        LocalDate dateTomorrow = dateToday.now().plusDays(1);

        LocalDate dateIn7Days = dateToday.now().plusDays(7);

        LocalDate dateIn8Days = dateToday.now().plusDays(8);

        LocalDate dateIn30Days = dateToday.now().plusDays(30);

        LocalDate dateIn34Days = dateToday.plusDays(34);


        //Creating venues
        Venue ibrox = new Venue("Ibrox");
        venueRepository.save(ibrox);

        Venue celtic = new Venue("Celtic Park");
        venueRepository.save(celtic);

        Venue hampden = new Venue("Hampden Park");
        venueRepository.save(hampden);

        Venue murrayfield = new Venue("Murrayfield");
        venueRepository.save(murrayfield);

        //Events
        Event football1 = new Event(dateToday , "1500", "Rangers v Kilmarnock", ibrox);
        eventRepository.save(football1);

        Event football2 = new Event(dateToday, "1900", "Celtic v Cally", celtic);
        eventRepository.save(football2);

        Event football3 = new Event(dateTomorrow, "1600", "Celtic v Barcelona", celtic);
        eventRepository.save(football3);

        Event football4 = new Event(dateIn8Days,"1200","Hearts v Motherwell", ibrox);
        eventRepository.save(football4);

        Event rugby1 = new Event(dateIn7Days, "1200", "Scotland v Ireland", hampden);
        eventRepository.save(rugby1);

        Event rugby2 = new Event(dateIn7Days, "1315", "Scotland v Wales", hampden);
        eventRepository.save(rugby2);

        Event rugby3 = new Event(dateIn30Days, "1700", "Scotland v England", murrayfield);
        eventRepository.save(rugby3);

        Event rugby4 = new Event(dateIn34Days, "1600", "Scotland v Wales", murrayfield);
        eventRepository.save(rugby4);


        //Creating users
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
