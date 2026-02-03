package com.example.day3studentmanagementsystem.Service;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Repository.StudentRepository;
import com.example.day3studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3studentmanagementsystem.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // create

    public StudentResponseDto addStudent(StudentRequestDto dto ) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
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
