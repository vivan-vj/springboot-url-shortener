package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Url shortener service.
 * @Author Vivek Jadhav
 */
@Service
public class UrlShortenerService {

    private final Map<String, String> urlMap = new ConcurrentHashMap<>();
    private final SecureRandom random = new SecureRandom();

    /**
     * Shorten string.
     *
     * @param longUrl the long url
     * @return the string
     */
    public String shorten(String longUrl) {
        String shortCode = generateCode();
        urlMap.put(shortCode, longUrl);
        return "http://localhost:9090/service/" + shortCode;
    }

    /**
     * Gets long url.
     *
     * @param shortCode the short code
     * @return the long url
     */
    public String getLongUrl(String shortCode) {
        return urlMap.getOrDefault(shortCode, "");
    }

    private String generateCode() {
        return Long.toHexString(random.nextLong()).substring(0, 6);
    }
}