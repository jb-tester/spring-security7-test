package com.mytests.spring.springsecurity7test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registered")
public class RegisteredController {
    @GetMapping("/test1")
    public ResponseEntity<String> registeredTest1() {
        return ResponseEntity.ok("registered test1");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> registeredTest2() {
        return ResponseEntity.ok("registered test2");
    }

    @GetMapping()
    public ResponseEntity<String> registeredRoot() {
        return ResponseEntity.ok("registered root");
    }
}
