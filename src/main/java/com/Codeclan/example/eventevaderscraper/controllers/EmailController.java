package com.Codeclan.example.eventevaderscraper.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmailController {

    @GetMapping(value = "/sendEmail/{email}")
    public String sendEmail(@PathVariable String email ){
        return "";
    }


}
