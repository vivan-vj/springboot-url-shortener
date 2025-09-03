package com.example.demo.controllers;

import com.example.demo.services.UrlShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * The type Url shortener controller.
 * @Author Vivek Jadhav
 */
@RestController
@RequestMapping("/service")
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    /**
     * Instantiates a new Url shortener controller.
     *
     * @param service the service
     */
    public UrlShortenerController(UrlShortenerService service) {
        this.urlShortenerService = service;
    }

    /**
     * Shorten url string.
     *
     * @param longUrl the long url
     * @return the string
     */
    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String longUrl) {
        return urlShortenerService.shorten(longUrl);
    }

    /**
     * Redirect response entity.
     *
     * @param shortCode the short code
     * @return the response entity
     */
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        String longUrl = urlShortenerService.getLongUrl(shortCode);
        if (null == longUrl || longUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }
}