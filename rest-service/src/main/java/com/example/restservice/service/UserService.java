package com.example.restservice.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.restservice.dao.UserRepository;
import com.example.restservice.model.User;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	@Cacheable()
	public List<User> getAll(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}
	
	public void delete(int id) {
        userRepository.deleteById(id);
    }
}
