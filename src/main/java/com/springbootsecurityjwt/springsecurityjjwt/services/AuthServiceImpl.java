package com.springbootsecurityjwt.springsecurityjjwt.services;

import com.springbootsecurityjwt.springsecurityjjwt.dto.LoginDTO;
import com.springbootsecurityjwt.springsecurityjjwt.dto.RegisterDTO;
import com.springbootsecurityjwt.springsecurityjjwt.models.Role;
import com.springbootsecurityjwt.springsecurityjjwt.models.User;
import com.springbootsecurityjwt.springsecurityjjwt.repositories.RoleRepository;
import com.springbootsecurityjwt.springsecurityjjwt.repositories.UserRepository;
import com.springbootsecurityjwt.springsecurityjjwt.utils.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Override
    public String login(LoginDTO loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

//    @Override
//    public User register(RegisterDTO registerDTO) {
//        Optional<User> storedUser = userRepository.findByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail());
//        if(storedUser.isPresent()) {
//
//        }
//        User user = new User();
//        user.setName(registerDTO.getName());
//        user.setEmail(registerDTO.getEmail());
//        user.setUsername(registerDTO.getUsername());
//        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
//
//        Set<Role> roles = new HashSet<>();
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        roles.add(userRole);
//        user.setRoles(roles);
//
//        return userRepository.save(user);
//    }
@Override
public User register(RegisterDTO registerDTO) {
    Optional<User> storedUser = userRepository.findByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail());
    if(storedUser.isPresent()) {
        return null;
    }
    User user = new User();
    user.setName(registerDTO.getName());
    user.setEmail(registerDTO.getEmail());
    user.setUsername(registerDTO.getUsername());
    user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

    Set<Role> roles = new HashSet<>();
    Role userRole = roleRepository.findByName("ROLE_USER");
    roles.add(userRole);
    user.setRoles(roles);

    return userRepository.save(user);
}
}
