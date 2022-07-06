package com.api.cloud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @GetMapping
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-name", "Spring-Cloud-Demo");
        return map;
    }
}
