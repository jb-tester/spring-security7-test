package com.mytests.spring.springsecurity7test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/test1")
    public ResponseEntity<String> userTest1() {
        return ResponseEntity.ok("user test1");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> userTest2() {
        return ResponseEntity.ok("user test2");
    }

    @GetMapping()
    public ResponseEntity<String> userRoot() {
        return ResponseEntity.ok("user root");
    }
}
