package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Easement;

@Repository
public interface EasementRepository extends JpaRepository<Easement, Long>{
    List<Easement> findByUser(User user);

    List<Easement> findByUserId(Long userId);
}
