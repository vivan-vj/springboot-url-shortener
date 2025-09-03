package com.example.demo.controllers;

import com.example.demo.services.UrlShortenerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UrlShortenerControllerTest {

    private final UrlShortenerService urlShortenerService = Mockito.mock(UrlShortenerService.class);
    private final UrlShortenerController urlShortenerController = new UrlShortenerController(urlShortenerService);

    @Test
    void shortenUrlReturnsShortenedUrl() {
        String longUrl = "http://example.com";
        String shortUrl = "http://short.ly/abc123";
        when(urlShortenerService.shorten(longUrl)).thenReturn(shortUrl);

        String result = urlShortenerController.shortenUrl(longUrl);

        assertEquals(shortUrl, result);
    }

    @Test
    void redirectReturnsFoundStatusWithCorrectLocation() {
        String shortCode = "abc123";
        String longUrl = "http://example.com";
        when(urlShortenerService.getLongUrl(shortCode)).thenReturn(longUrl);
        ResponseEntity<Void> response = urlShortenerController.redirect(shortCode);

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(URI.create(longUrl), response.getHeaders().getLocation());
    }

    @Test
    void redirectReturnsNotFoundForInvalidShortCode() {
        String shortCode = "invalid";
        when(urlShortenerService.getLongUrl(shortCode)).thenReturn(null);
        ResponseEntity<Void> response = urlShortenerController.redirect(shortCode);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}