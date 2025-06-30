package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            logger.error("Login failed: username or password is null");
            return false;
        }

        if ("admin".equals(username) && "admin123".equals(password)) {
            return true;
        } else {
            logger.warn("Login attempt failed for user: {}", username);
            return false;
        }
    }
}
