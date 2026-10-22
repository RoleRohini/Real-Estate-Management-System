package com.example.realestate.service;

import com.example.realestate.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}