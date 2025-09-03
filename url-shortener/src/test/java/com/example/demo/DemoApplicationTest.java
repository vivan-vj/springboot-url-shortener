package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DemoApplicationTest {

    @Test
    void applicationStartsWithoutExceptions() {
        assertDoesNotThrow(() -> DemoApplication.main(new String[]{}));
    }
}