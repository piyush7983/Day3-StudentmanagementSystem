package com.example.day3studentmanagementsystem.Controller;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Service.StudentService;
//import org.springframework.web.bind.annotation.GetMapping;
import com.example.day3studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3studentmanagementsystem.dto.StudentResponseDto;
import jakarta.validation.Valid;
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
    public StudentResponseDto addStudent(@Valid  @RequestBody StudentRequestDto student){
        return service.addStudent(student);

    }

    // Display Student

    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getStudent();
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,  @Valid @RequestBody StudentRequestDto student){
        return service.update(id,student);
    }

    @DeleteMapping("delete/{id}")
    public StudentResponseDto delete(@PathVariable String id){
        return service.delete(id);
    }






}
