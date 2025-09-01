package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtRequest {
    private String username;
    private String role;

    public JwtRequest(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
