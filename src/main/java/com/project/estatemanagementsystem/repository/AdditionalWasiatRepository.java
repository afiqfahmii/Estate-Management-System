package com.project.estatemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.AdditionalWasiat;

@Repository
public interface AdditionalWasiatRepository extends JpaRepository<AdditionalWasiat, Long> {

    List<AdditionalWasiat> findByUser(User user); //?USER SEE LIST
    
    List<AdditionalWasiat> findByUserId(User user);

    void deleteByUserId(Long userId);

    // ?edit
    AdditionalWasiat findByUserId(Long userId);
 
    
}
