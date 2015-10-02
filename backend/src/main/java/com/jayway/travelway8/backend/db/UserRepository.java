package com.jayway.travelway8.backend.db;

import com.jayway.travelway8.backend.model.User;

import java.util.Collection;

public interface UserRepository {
    void addUser(User user);
    User getUserByName(String userName);
    Collection<User> getAllUsers();
}
