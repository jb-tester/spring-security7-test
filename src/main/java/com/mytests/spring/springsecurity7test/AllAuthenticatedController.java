package com.mytests.spring.springsecurity7test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AllAuthenticatedController {
    @GetMapping("/foo")
    public ResponseEntity<String> foo() {
        return ResponseEntity.ok("foo");
    }

    @GetMapping("/bar")
    public ResponseEntity<String> bar() {
        return ResponseEntity.ok("bar");
    }
}
