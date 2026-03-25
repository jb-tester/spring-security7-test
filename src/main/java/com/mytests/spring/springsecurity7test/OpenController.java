package com.mytests.spring.springsecurity7test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class OpenController {
    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("home endpoint");
    }

    @GetMapping()
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("root endpoint");
    }

    @PostMapping()
    public ResponseEntity<String> post(@RequestBody String body) {
        return ResponseEntity.ok("root post " + body);
    }
    @PostMapping("/home")
    public ResponseEntity<String> post2(@RequestBody String body) {
        return ResponseEntity.ok("post2 " + body);
    }
}
