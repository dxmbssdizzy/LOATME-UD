package com.loatme.loatmebackend.service;

import com.loatme.loatmebackend.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final Map<String, User> usersByEmail = new HashMap<>();

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(usersByEmail.get(email.toLowerCase()));
    }

    public boolean registerUser(User user) {
        String emailKey = user.getEmail().toLowerCase();
        if (usersByEmail.containsKey(emailKey)) {
            return false; // User already exists
        }
        usersByEmail.put(emailKey, user);
        return true;
    }

    public boolean authenticate(String email, String password) {
        User user = usersByEmail.get(email.toLowerCase());
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
