package com.example.demo.controllers;


import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.services.JwtServiceUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/jwt")
public class JwtController {

    @Autowired
    private JwtServiceUtil jwtServiceUtil;

    public void init() {
        log.info("JwtController initialized");
    }

    @PostMapping(value = "/token", consumes = "application/json", produces = "application/json")
    public ResponseEntity<JwtResponse> getJWTToken(@RequestBody JwtRequest jwtRequest) {
        try {
            String username = jwtRequest.getUsername();
            String role = jwtRequest.getRole();
            String token = jwtServiceUtil.generateToken(username);
            String expiration = String.valueOf(System.currentTimeMillis() + jwtServiceUtil.getExpiration());
            JwtResponse jwtResponse = new JwtResponse(token, expiration, username, role);
            return ResponseEntity.ok(jwtResponse);
        } catch (Exception e) {
            log.error("Error generating JWT token", e);
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/validate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> validateToken(@RequestBody JwtRequest jwtRequest, HttpServletRequest request) {
        try {
            String username = jwtRequest.getUsername();
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(400).body("Missing or invalid Authorization header");
            }
            String token = authHeader.replace("Bearer ", "");
            boolean isValid = jwtServiceUtil.validateToken(token, username);
            if (isValid) {
                return ResponseEntity.ok("Token is valid");
            } else {
                return ResponseEntity.status(401).body("Token is invalid or expired");
            }
        } catch (Exception e) {
            log.error("Error validating JWT token", e);
            return ResponseEntity.status(500).build();
        }
    }

}
