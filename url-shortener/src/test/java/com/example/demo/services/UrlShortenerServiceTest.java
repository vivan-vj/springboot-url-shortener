package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Url shortener service test.
 */
class UrlShortenerServiceTest {

    private final UrlShortenerService urlShortenerService = new UrlShortenerService();

    /**
     * Shorten generates valid short url.
     */
    @Test
    void shortenGeneratesValidShortUrl() {
        String longUrl = "http://example.com";
        String shortUrl = urlShortenerService.shorten(longUrl);

        assertTrue(shortUrl.startsWith("http://localhost:9090/service/"));
        assertEquals(longUrl, urlShortenerService.getLongUrl(shortUrl.substring(shortUrl.lastIndexOf("/") + 1)));
    }

    /**
     * Gets long url returns empty string for invalid short code.
     */
    @Test
    void getLongUrlReturnsEmptyStringForInvalidShortCode() {
        String result = urlShortenerService.getLongUrl("invalidCode");

        assertEquals("", result);
    }

    /**
     * Shorten generates unique codes for different urls.
     */
    @Test
    void shortenGeneratesUniqueCodesForDifferentUrls() {
        String longUrl1 = "http://example1.com";
        String longUrl2 = "http://example2.com";

        String shortUrl1 = urlShortenerService.shorten(longUrl1);
        String shortUrl2 = urlShortenerService.shorten(longUrl2);

        assertTrue(!shortUrl1.equals(shortUrl2));
    }
}