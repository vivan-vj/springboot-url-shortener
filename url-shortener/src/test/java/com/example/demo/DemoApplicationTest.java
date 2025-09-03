package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * The type Demo application test.
 */
class DemoApplicationTest {

    /**
     * Application starts without exceptions.
     */
    @Test
    void applicationStartsWithoutExceptions() {
        assertDoesNotThrow(() -> DemoApplication.main(new String[]{}));
    }
}