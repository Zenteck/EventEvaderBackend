package com.Codeclan.example.eventevaderscraper.repositories;

import com.Codeclan.example.eventevaderscraper.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {
}
