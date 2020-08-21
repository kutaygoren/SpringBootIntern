package com.example.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.model.User;
import com.example.restservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    UserService userService;
	
	@GetMapping("/getall")
    private List<User> getAllUsers() {
        return userService.getAll();
    }
	
	@DeleteMapping("/delete/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }
	
	@PostMapping("/save")
    private int saveUser(@RequestBody User user) {
        userService.save(user);
        return user.getID();
    }

}
