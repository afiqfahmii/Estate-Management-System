package com.project.estatemanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.estatemanagementsystem.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    
}
