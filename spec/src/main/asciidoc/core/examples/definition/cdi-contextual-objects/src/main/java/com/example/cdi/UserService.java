package com.example.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named
public class UserService {

    // 1. application's state
    private int userCount = 0;

    // 2. application's logic
    // 2.1
    public void registerUser(String username) {
        userCount++;
        System.out.println("Usuario registrado: " + username);
    }
    // 2.2
    public int getUserCount() {
        return userCount;
    }
}
