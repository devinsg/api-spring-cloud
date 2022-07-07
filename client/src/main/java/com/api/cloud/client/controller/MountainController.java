package com.api.cloud.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mountain")
public class MountainController {

    @RequestMapping("/")
    public String get() {
        return "this is Spring Boot Application";
    }
}
