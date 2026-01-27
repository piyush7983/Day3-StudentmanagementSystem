package com.example.day3studentmanagementsystem.Service;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Display

    public List<StudentModel> getStudent(){
        return repository.findAll();
    }

    //update

    public StudentModel update(String id, StudentModel student){
        StudentModel existing =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no student found"));
        existing.setId(student.getId());
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());

        return repository.save(existing);


    }

    // delete
    public void delete(String id){
        StudentModel existing =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("no student found"));
        repository.delete(existing);
    }

}
