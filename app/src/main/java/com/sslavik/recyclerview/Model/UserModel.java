package com.sslavik.recyclerview.Model;

public class UserModel {
    private String name;
    private String email;

    public UserModel(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
