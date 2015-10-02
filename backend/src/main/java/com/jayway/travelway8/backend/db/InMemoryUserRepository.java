package com.jayway.travelway8.backend.db;

import com.jayway.travelway8.backend.model.User;
import org.jvnet.hk2.annotations.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> cache = new ConcurrentHashMap<>();

    public InMemoryUserRepository() {
        // Add dummy data
        addUser(new User("Per Persson", "123456789", new Date(), "+4612345678", "per.persson@travelway.com",
                "Swedish", "8001011234"));
        addUser(new User("Nils Nilsson", "987654321", new Date(), "+4687654321", "nils.nilsson@travelway.com",
                "Swedish", "8102022222"));
    }

    @Override
    public void addUser(User user) {
        cache.put(user.getEmail(), user);
    }

    @Override
    public User getUserByEmail(String email) {
        return cache.get(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return cache.values();
    }
}
