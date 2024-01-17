package com.example.demo.payload;

import java.io.Serializable;

public class AutenticationResponse implements Serializable {

    private static final long serialVersionUID = 1;

    private String token;

    public AutenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
