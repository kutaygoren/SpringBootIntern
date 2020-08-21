package com.example.restservice.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.dao.DeveloperRepository;
import com.example.restservice.model.Developer;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private DeveloperRepository developerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public DeveloperController(DeveloperRepository developerRepository,
                               BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.developerRepository = developerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody Developer developer) {
        developer.setPassword(bCryptPasswordEncoder.encode(developer.getPassword()));
        developerRepository.save(developer);
    }
}
