package com.api.cloud.client.controller;

import com.api.cloud.client.dao.MountainDao;
import com.api.cloud.client.models.Mountain;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mountain")
public class MountainController {
    private MountainDao dao;

    public MountainController() {
        dao = new MountainDao();
    }

    @RequestMapping("/")
    public String get() {
        return "this is Spring Boot Application";
    }

    @RequestMapping("/list")
    public List<Mountain> getList() {
        return dao.getList();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mountain getById(@PathVariable("id") Long id) {
        Mountain mountain = dao.getById(id);
        return mountain;
    }
}
