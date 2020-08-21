package com.example.restservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer findByUsername(String username);
}
