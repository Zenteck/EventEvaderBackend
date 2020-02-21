package com.Codeclan.example.eventevaderscraper.components;


import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.models.Venue;
import com.Codeclan.example.eventevaderscraper.repositories.EventRepository;
import com.Codeclan.example.eventevaderscraper.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EventRepository eventRepository;

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    VenueRepository venueRepository;

    public DataLoader(){

    }


    @Scheduled(cron = "0 0 9-21 * * *")
    public void run(ApplicationArguments args) {

        Venue ibrox = new Venue("Ibrox");
        venueRepository.save(ibrox);

        Venue celtic = new Venue("Celtic Park");
        venueRepository.save(celtic);

        Venue hampden = new Venue("Hampden Park");
        venueRepository.save(hampden);


        Event football1 = new Event("20/02", "1500", "Rangers v Kilmarnock", ibrox);
        eventRepository.save(football1);

        Event football2 = new Event("27/02", "1900", "Celtic v Cally", celtic);
        eventRepository.save(football2);

        Event rugby1 = new Event("24/02", "1200", "Scotland v Ireland", hampden);
        eventRepository.save(rugby1);

        Event rugby2 = new Event("01/03", "1315", "Scotland v Wales", hampden);
        eventRepository.save(rugby2);


    }


}
