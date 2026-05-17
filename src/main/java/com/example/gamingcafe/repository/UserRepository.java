package com.example.gamingcafe.repository;

import com.example.gamingcafe.model.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUser(String username);
    List<User> findAllUsers();

    // TODO: Add more as needed
}
