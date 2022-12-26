package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    private final String id;

    @Getter
    private final String password;

    @Getter
    private String name;

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public static User create(String id, String password, String name) {
        return new User(id, password, name);
    }
}
