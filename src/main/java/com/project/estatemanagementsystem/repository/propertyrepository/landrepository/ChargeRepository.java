package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Charge;

@Repository
public interface ChargeRepository extends JpaRepository<Charge, Long>{
    List<Charge> findByUser(User user);

    List<Charge> findByUserId(Long userId);
}
