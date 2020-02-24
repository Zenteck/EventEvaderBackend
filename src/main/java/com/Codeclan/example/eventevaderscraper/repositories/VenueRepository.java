package com.Codeclan.example.eventevaderscraper.repositories;

import com.Codeclan.example.eventevaderscraper.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository <Venue, Long>{

    List<Venue> findAll();
    Venue findByPlaceId(String placeId);
}
