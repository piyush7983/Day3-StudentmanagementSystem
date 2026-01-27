package com.example.day3studentmanagementsystem.Controller;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Service.StudentService;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Display Student

    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudent();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id,@RequestBody StudentModel student){
        return service.update(id,student);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }






}
