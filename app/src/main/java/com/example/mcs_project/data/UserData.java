package com.example.mcs_project.data;

public class UserData {
    int id;
    public String name, email, password, phone;

    public UserData(int id, String name, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

}
