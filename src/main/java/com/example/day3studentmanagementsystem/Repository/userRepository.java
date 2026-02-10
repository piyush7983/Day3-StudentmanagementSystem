package com.example.day3studentmanagementsystem.Repository;

import com.example.day3studentmanagementsystem.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface userRepository extends MongoRepository<UserModel, String> {
    Optional<UserModel> findByEmail(String email);
}
