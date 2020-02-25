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

        Event azharEvent1 = eventRepository.getOne(1L);
        Event alanEvent1 = eventRepository.getOne(2L);


        Venue azharVenue = venueRepository.getOne(1L);
        Venue alanVenue = venueRepository.getOne(2L);

//        Event football1 = new Event("20/02", "1500", "Rangers v Kilmarnock", ibrox);
//        eventRepository.save(football1);
//
//        Event football2 = new Event("27/02", "1900", "Celtic v Cally", celtic);
//        eventRepository.save(football2);
//
//        Event rugby1 = new Event("24/02", "1200", "Scotland v Ireland", hampden);
//        eventRepository.save(rugby1);
//
//        Event rugby2 = new Event("01/03", "1315", "Scotland v Wales", hampden);
//        eventRepository.save(rugby2);

        User alan = new User("spambox@zenteck.co.uk");
//        alan.addVenue(celtic);
        alan.addEvent(alanEvent1);
        alan.addVenue(alanVenue);
        userRepository.save(alan);

        User azhar = new User("codeninja@codeclan.com");
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
