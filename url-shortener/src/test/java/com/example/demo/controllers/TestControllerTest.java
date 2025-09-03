package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Test controller test.
 */
class TestControllerTest {

    private final TestController testController = new TestController();

    /**
     * Hello returns expected message.
     */
    @Test
    void helloReturnsExpectedMessage() {
        String response = testController.hello();
        assertEquals("Hello, World!", response);
    }

    /**
     * Health check returns ok status.
     */
    @Test
    void healthCheckReturnsOkStatus() {
        ResponseEntity<Void> response = testController.healthCheck();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}