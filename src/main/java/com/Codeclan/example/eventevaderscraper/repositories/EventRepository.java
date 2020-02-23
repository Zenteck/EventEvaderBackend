package com.Codeclan.example.eventevaderscraper.repositories;

import com.Codeclan.example.eventevaderscraper.models.Event;
import com.Codeclan.example.eventevaderscraper.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {

    List<Event> findByVenueId(long id);

    List<Event> findByDate(LocalDate date);

}
