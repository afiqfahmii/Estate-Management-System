package com.project.estatemanagementsystem.repository.propertyrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Bond;

@Repository
public interface BondRepository extends JpaRepository<Bond, Long>{
    List<Bond> findByUser(User user);

    List<Bond> findByUserId(Long userId);
}
