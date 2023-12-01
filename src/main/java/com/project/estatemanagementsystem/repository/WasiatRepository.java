package com.project.estatemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.estatemanagementsystem.entity.WasiatForm;

public interface WasiatRepository extends JpaRepository <WasiatForm, Long>{
    
}
