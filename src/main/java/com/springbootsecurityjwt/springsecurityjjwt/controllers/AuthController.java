package com.springbootsecurityjwt.springsecurityjjwt.controllers;

import com.springbootsecurityjwt.springsecurityjjwt.dto.JwtAuthResponse;
import com.springbootsecurityjwt.springsecurityjjwt.dto.LoginDTO;
import com.springbootsecurityjwt.springsecurityjjwt.dto.RegisterDTO;
import com.springbootsecurityjwt.springsecurityjjwt.dto.RegisterResponse;
import com.springbootsecurityjwt.springsecurityjjwt.models.User;
import com.springbootsecurityjwt.springsecurityjjwt.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDTO loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterDTO registerDTO) {
        User user = authService.register(registerDTO);
        if(user==null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(user.getId());
        registerResponse.setName(user.getName());
        registerResponse.setEmail(user.getEmail());
        registerResponse.setUsername(user.getUsername());
        return new ResponseEntity<>(registerResponse, HttpStatus.OK);
    }
}