package com.jayway.travelway8.backend.db;

import com.jayway.travelway8.backend.model.User;
import com.jayway.travelway8.backend.model.UserImpl;
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
        addUser(new UserImpl("Per Persson", "123456789", new Date(), "+4612345678", "per.persson@travelway.com",
                "Swedish", "8001011234"));
        addUser(new UserImpl("Nils Nilsson", "987654321", new Date(), "+4687654321", "nils.nilsson@travelway.com",
                "Swedish", "8102022222"));
    }

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
