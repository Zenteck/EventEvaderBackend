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
import org.springframework.stereotype.Component;

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

    public void run(ApplicationArguments args) {

        userRepository.deleteAll();
        eventRepository.deleteAll();
        venueRepository.deleteAll();


        Venue ibrox = new Venue("Ibrox Stadium", "9a37fbc9-19e0-892b-f58b-c6f40000aaa5");
        venueRepository.save(ibrox);

        Venue celtic = new Venue("Celtic Park", "b940eadd-4f1e-b60e-85e0-bcc40000356f");
        venueRepository.save(celtic);

        Venue hampden = new Venue("Hampden Park", "2c9fdadd-4f1e-b60e-33e0-bcc400002a94");
        venueRepository.save(hampden);


        Event football1 = new Event("20/02", "1500", "Rangers v Kilmarnock", ibrox);
        eventRepository.save(football1);

        Event football2 = new Event("27/02", "1900", "Celtic v Cally", celtic);
        eventRepository.save(football2);

        Event rugby1 = new Event("24/02", "1200", "Scotland v Ireland", hampden);
        eventRepository.save(rugby1);

        Event rugby2 = new Event("01/03", "1315", "Scotland v Wales", hampden);
        eventRepository.save(rugby2);


        User alan = new User("apps+eventevader@zenteck.co.uk");
        alan.addVenue(celtic);
        alan.addEvent(football2);
        userRepository.save(alan);

        User azhar = new User("codeninja@codeclan.com");
        azhar.addVenue(ibrox);
        azhar.addVenue(hampden);
        azhar.addEvent(football1);
        userRepository.save(azhar);

        User eleanor = new User("plattsnpink@gmail.com");
        eleanor.addVenue(hampden);
        eleanor.addEvent(rugby1);
        eleanor.addEvent(rugby2);
        userRepository.save(eleanor);

    }
}
