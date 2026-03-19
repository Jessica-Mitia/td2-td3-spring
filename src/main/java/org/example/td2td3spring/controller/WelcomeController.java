package org.example.td2td3spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private static final String template = "Welcome %s!";

    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "user") String name) {
        return String.format(template, name);
    }
}