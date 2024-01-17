package com.example.demo.payload;

import java.io.Serializable;

public class AutenticationLogin implements Serializable {

    private static final long serialVersionUID = 1;

    private String username;

    private String password;

    public AutenticationLogin() {
    }

    public AutenticationLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
