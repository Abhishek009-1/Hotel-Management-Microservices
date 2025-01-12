package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {
    //create
    User saveUser(User user);
    //getAllUser
    List<User> getUsers();
    //getSingleUser of given Id
    User getUser(String id);
}
