package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtResponse {
    private String token;
    private String expiration;
    private String username;
    private String role;

    public JwtResponse(String token, String expiration, String username, String role) {
        this.token = token;
        this.expiration = expiration;
        this.username = username;
        this.role = role;
    }
}
