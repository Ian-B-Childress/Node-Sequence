package com.sequence.models;

public class User {
    public int userId;
    public String username;

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public User(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
