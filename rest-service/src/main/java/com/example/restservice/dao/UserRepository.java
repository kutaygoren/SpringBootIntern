package com.example.restservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
