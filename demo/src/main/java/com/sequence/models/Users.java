package com.sequence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;

    public Users(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Users(){}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
