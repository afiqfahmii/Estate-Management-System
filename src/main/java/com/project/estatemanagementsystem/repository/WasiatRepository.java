package com.project.estatemanagementsystem.repository;

<<<<<<< Updated upstream
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.estatemanagementsystem.entity.WasiatForm;

public interface WasiatRepository extends JpaRepository <WasiatForm, Long>{
=======
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.Wasiat;

@Repository
public interface WasiatRepository extends JpaRepository<Wasiat, Long> {

    List<Wasiat> findByUser(User user); //?USER SEE LIST
    
    List<Wasiat> findByUserId(User user);

    void deleteByUserId(Long userId);

    // ?edit
    Wasiat findByUserId(Long userId);
 
>>>>>>> Stashed changes
    
}
