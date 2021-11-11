package com.example.semana14;

public class User
{
    private String username;
    private String id;

    public User()
    {

    }

    public User(String username, String id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


