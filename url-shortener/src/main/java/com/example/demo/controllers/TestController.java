package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/test")
public class TestController {


    @GetMapping("/hello")
    public String hello() {
        log.info("Hello endpoint was called");
        return "Hello, World!";
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok().build();
    }

}
