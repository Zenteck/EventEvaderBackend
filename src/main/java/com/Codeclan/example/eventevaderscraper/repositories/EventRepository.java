package com.Codeclan.example.eventevaderscraper.repositories;

import com.Codeclan.example.eventevaderscraper.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {

    List<Event> findByVenueId(long id);

    List<Event> findByStartTime(LocalDateTime date);

    List<Event> findByStartTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

}
