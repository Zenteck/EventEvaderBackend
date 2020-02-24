package com.Codeclan.example.eventevaderscraper.repositories;

import com.Codeclan.example.eventevaderscraper.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {


}
