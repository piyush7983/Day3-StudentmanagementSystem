package com.example.day3studentmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@AllArgsConstructor //makes constructor of below variables
@NoArgsConstructor  //for null value
@Document(collection =  "student" )
    public class StudentRequestDto {


        @Id
        private String id;

        @NotBlank(message = "name invalid")
        private String name;

        @Min(value=5, message = "can't be less than 5")
        @Max(value=90, message = "can't be more than 90")
        private int age;

        @Email(message = "invalid email")
        @NotBlank(message = "email cant be blank")
        private String email;

    }

