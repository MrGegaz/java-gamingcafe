package com.example.gamingcafe.repository;

import com.example.gamingcafe.model.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void saveUser(User user) {
        // TODO:
        // 1. connection from Singleton (DatabaseManager)
        // 2. Make SQL query (ex. INSERT INTO...)
        // 3. Execute
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }
}
