package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Test controller.
 * @Author Vivek Jadhav
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {


    /**
     * Hello string.
     *
     * @return the string
     */
    @GetMapping("/hello")
    public String hello() {
        log.info("Hello endpoint was called");
        return "Hello, World!";
    }

    /**
     * Health check response entity.
     *
     * @return the response entity
     */
    @GetMapping("/healthCheck")
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok().build();
    }

}
