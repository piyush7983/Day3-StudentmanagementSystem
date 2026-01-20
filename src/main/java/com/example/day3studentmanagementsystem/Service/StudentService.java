package com.example.day3studentmanagementsystem.Service;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // create

    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

}
