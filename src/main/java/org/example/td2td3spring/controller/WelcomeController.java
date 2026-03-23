package org.example.td2td3spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name) {
        if (name == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Name is required");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Welcome " + name);
    }
}
