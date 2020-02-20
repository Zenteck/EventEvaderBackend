package com.Codeclan.example.eventevaderscraper.repositories;

import com.Codeclan.example.eventevaderscraper.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository <Venue, Long>{
}
