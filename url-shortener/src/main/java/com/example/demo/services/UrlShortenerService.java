package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UrlShortenerService {

    private final Map<String, String> urlMap = new ConcurrentHashMap<>();
    private final SecureRandom random = new SecureRandom();

    public String shorten(String longUrl) {
        String shortCode = generateCode();
        urlMap.put(shortCode, longUrl);
        return "http://localhost:9090/service/" + shortCode;
    }

    public String getLongUrl(String shortCode) {
        return urlMap.getOrDefault(shortCode, "");
    }

    private String generateCode() {
        return Long.toHexString(random.nextLong()).substring(0, 6);
    }
}