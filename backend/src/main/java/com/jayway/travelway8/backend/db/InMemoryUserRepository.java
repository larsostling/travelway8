package com.jayway.travelway8.backend.db;

import com.jayway.travelway8.backend.model.User;
import org.jvnet.hk2.annotations.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> cache = new ConcurrentHashMap<>();

    @Override
    public void addUser(User user) {
        cache.put(user.getPassportName(), user);
    }

    @Override
    public User getUserByName(String userName) {
        return cache.get(userName);
    }

    @Override
    public Collection<User> getAllUsers() {
        return cache.values();
    }
}
