package com.example.day3studentmanagementsystem.Controller;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Service.StudentService;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    // create function Api

    @PostMapping("/add_student")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);

    }

}
