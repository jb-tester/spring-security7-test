package com.mytests.spring.springsecurity7test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/test1")
    public ResponseEntity<String> adminTest1() {
        return ResponseEntity.ok("admin test1");
    }

    @GetMapping()
    public ResponseEntity<String> adminRoot() {
        return ResponseEntity.ok("admin root");
    }
    @GetMapping("/regex111")
    public ResponseEntity<String> regex111() {
        return ResponseEntity.ok("admin regex111");
    }
}
