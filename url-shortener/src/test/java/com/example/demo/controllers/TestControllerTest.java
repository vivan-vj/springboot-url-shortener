package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestControllerTest {

    private final TestController testController = new TestController();

    @Test
    void helloReturnsExpectedMessage() {
        String response = testController.hello();
        assertEquals("Hello, World!", response);
    }

    @Test
    void healthCheckReturnsOkStatus() {
        ResponseEntity<Void> response = testController.healthCheck();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}