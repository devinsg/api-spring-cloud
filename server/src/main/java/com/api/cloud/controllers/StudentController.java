package com.api.cloud.controllers;

import com.api.cloud.models.Student;
import com.api.cloud.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController() {
        studentService = new StudentService();
    }

    @GetMapping(value="/list")
    public List<Student> getList() {
        return studentService.getList();
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public Student getById(@PathVariable("id") long id) {
        return studentService.getById(id);
    }
}
