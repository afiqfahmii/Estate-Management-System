package com.project.estatemanagementsystem.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.estatemanagementsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findByIDNum(String idNum);

    
}
