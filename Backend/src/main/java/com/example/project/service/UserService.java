package com.example.project.service;

import com.example.project.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> saveUsers(List<User> users);
    User getUserById(int id);
    User getUserByEmail(String email);
    List<User> getUsers();
    User updateUser(User user);
    String deleteUser(int id);
}
