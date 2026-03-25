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

    @GetMapping("/foo/master")
    public ResponseEntity<String> fooMaster() {
        return ResponseEntity.ok("foo master");
    }

    @GetMapping("/bar")
    public ResponseEntity<String> bar() {
        return ResponseEntity.ok("bar");
    }

    @GetMapping("/bar/test/master")
    public ResponseEntity<String> barMaster() {
        return ResponseEntity.ok("bar master");
    }
}
