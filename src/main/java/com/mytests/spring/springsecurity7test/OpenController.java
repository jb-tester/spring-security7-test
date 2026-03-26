package com.mytests.spring.springsecurity7test;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/")
public class OpenController {
    @GetMapping("/home")
    public ResponseEntity<String> home(@CurrentSecurityContext SecurityContext context) {
        String details = Objects.requireNonNull(context.getAuthentication()).toString();
        return ResponseEntity.ok("home endpoint: " + details);
    }

    @GetMapping()
    public ResponseEntity<String> root(@CurrentSecurityContext SecurityContext context) {
        String details = Objects.requireNonNull(context.getAuthentication()).toString();
        return ResponseEntity.ok("root endpoint: " + details);
    }

    @PostMapping()
    public ResponseEntity<String> post(@RequestBody String body, @CurrentSecurityContext SecurityContext context) {
        String details = Objects.requireNonNull(context.getAuthentication()).toString();
        return ResponseEntity.ok("root post: " + body + ", authentication: " + details);
    }
    @PostMapping("/home")
    public ResponseEntity<String> post2(@RequestBody String body, @CurrentSecurityContext SecurityContext context) {
        String details = Objects.requireNonNull(context.getAuthentication()).toString();
        return ResponseEntity.ok("post2: " + body + ", authentication: " + details);
    }
}
