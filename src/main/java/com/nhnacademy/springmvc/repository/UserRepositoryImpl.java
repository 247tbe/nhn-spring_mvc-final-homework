package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public User addUser(String id, String password, String name) {
        User user = User.create(id, password, name);

        userMap.put(id, user);

        return user;
    }
}
