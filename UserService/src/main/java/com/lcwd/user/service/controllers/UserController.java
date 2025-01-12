package com.lcwd.user.service.controllers;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    //create
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
       User user1= userService.saveUser(user);
       return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //single user get
    @GetMapping("/{userId}")
    public  ResponseEntity<User> getUserById(@PathVariable(value = "userId") String id) {
       User user= userService.getUser(id);
        System.out.println(user);
       return ResponseEntity.ok(user);
    }

    //all user get

    @GetMapping()
    public  ResponseEntity<List<User>> getAllUsers() {
        List<User> users=userService.getUsers();
        return ResponseEntity.ok(users);
    }



}
