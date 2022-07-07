package com.api.cloud.services;

import com.api.cloud.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private List<Student> studentList = new ArrayList<Student>();

    public StudentService() {
        Student s1 = new Student();
        s1.setId(1L);
        s1.setFirstName("Johny");
        s1.setSurName("Walker");
        studentList.add(s1);

        Student s2 = new Student();
        s2.setId(2L);
        s2.setFirstName("Martin");
        s2.setSurName("Reward");
        studentList.add(s2);
    }

    public Student getById(long id) {
        int position = (int) --id;
        return studentList.get(position);
    }

    public List<Student> getList() {
        return studentList;
    }
}
