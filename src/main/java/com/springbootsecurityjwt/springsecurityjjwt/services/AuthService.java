package com.springbootsecurityjwt.springsecurityjjwt.services;

import com.springbootsecurityjwt.springsecurityjjwt.dto.LoginDTO;
import com.springbootsecurityjwt.springsecurityjjwt.dto.RegisterDTO;
import com.springbootsecurityjwt.springsecurityjjwt.models.User;

public interface AuthService {
    String login(LoginDTO loginDto);
    User register(RegisterDTO registerDTO);
}