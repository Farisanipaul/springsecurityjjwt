package com.springbootsecurityjwt.springsecurityjjwt.controllers;

import com.springbootsecurityjwt.springsecurityjjwt.dto.JwtAuthResponse;
import com.springbootsecurityjwt.springsecurityjjwt.dto.LoginDTO;
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
}