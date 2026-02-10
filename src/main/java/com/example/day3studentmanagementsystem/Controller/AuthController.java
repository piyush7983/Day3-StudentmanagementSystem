package com.example.day3studentmanagementsystem.Controller;

import com.example.day3studentmanagementsystem.Model.UserModel;
import com.example.day3studentmanagementsystem.Repository.userRepository;
import com.example.day3studentmanagementsystem.Service.AuthService;
import com.example.day3studentmanagementsystem.dto.LoginRequestDto;
import com.example.day3studentmanagementsystem.dto.RegisterRequestDto;
import com.example.day3studentmanagementsystem.dto.TokenResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto user) {
        return service.login(user);
    }

    @PostMapping("/register")
    public TokenResponseDto register(@RequestBody RegisterRequestDto user) {
        return service.register(user);
    }

}
