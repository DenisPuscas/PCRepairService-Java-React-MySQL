package com.example.project.data;

import com.example.project.entity.User;

import java.util.List;

public interface UserData {
    User saveUser(User user);
    List<User> saveUsers(List<User> users);
    List<User> getUsers();
    User getUserById(int id);
    User getUserByEmail(String email);
    String deleteUser(int id);
    User updateUser(User user);
}
