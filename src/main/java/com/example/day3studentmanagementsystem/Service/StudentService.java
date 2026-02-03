package com.example.day3studentmanagementsystem.Service;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Repository.StudentRepository;
import com.example.day3studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3studentmanagementsystem.dto.StudentResponseDto;
import com.example.day3studentmanagementsystem.exception.StudentNotFound;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public List<StudentResponseDto> getStudent() {
        return repository.findAll()
                .stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getEmail()
                ))
                .toList();
    }


    //update

    public StudentResponseDto update(String id, @Valid StudentRequestDto dto) {
        StudentModel existing = repository.findById(id)
                .orElseThrow(() -> new StudentNotFound("Student not found"));

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setEmail(dto.getEmail());

        StudentModel saved = repository.save(existing);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }


    // delete


    public StudentResponseDto delete(String id){
        StudentModel existing =  repository.findById(id)
                .orElseThrow(() -> new StudentNotFound("no student found"));
        repository.delete(existing);

        return null;
    }

}
