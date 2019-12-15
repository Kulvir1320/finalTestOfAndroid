package com.example.finaltest_764928;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDetails implements Serializable {
    private String name;
    private String email;
    private String phone;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserDetails(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public  static ArrayList<UserDetails> DetailsOfUser = new ArrayList<>();
}
