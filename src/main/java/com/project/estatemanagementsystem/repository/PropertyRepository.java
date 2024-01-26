package com.project.estatemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{

    List<Property> findByUser(User user);

    List<Property> findByUserId(Long userId);
}
