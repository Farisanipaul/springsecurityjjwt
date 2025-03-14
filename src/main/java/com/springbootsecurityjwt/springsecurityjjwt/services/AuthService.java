package com.springbootsecurityjwt.springsecurityjjwt.services;

import com.springbootsecurityjwt.springsecurityjjwt.dto.LoginDTO;

public interface AuthService {
    String login(LoginDTO loginDto);
}