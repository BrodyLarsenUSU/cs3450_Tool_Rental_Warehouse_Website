package com.softwareEngineering.Spring.Models.DTOs;

public class loginDto{

    private String username;
    private String password;

    public loginDto(){}

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}