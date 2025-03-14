package com.springbootsecurityjwt.springsecurityjjwt.repositories;

import com.springbootsecurityjwt.springsecurityjjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}