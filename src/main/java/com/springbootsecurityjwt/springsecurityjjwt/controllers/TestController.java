package com.springbootsecurityjwt.springsecurityjjwt.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/checkster/check")
public class TestController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/tests")
    public ResponseEntity<String> testAll(){
        return new ResponseEntity<>("jwtAuthResponse", HttpStatus.OK);
    }
}
