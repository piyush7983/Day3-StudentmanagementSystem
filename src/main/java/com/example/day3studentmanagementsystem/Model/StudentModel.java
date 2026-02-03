package com.example.day3studentmanagementsystem.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor //makes constructor of below variables
@NoArgsConstructor  //for null value
@Document(collection =  "student" )
public class StudentModel {

    @Id
    private String id;
    private String name;
    private int age;
    private String email;

}
