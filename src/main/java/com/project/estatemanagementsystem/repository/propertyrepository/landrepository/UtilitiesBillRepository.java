package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.UtilitiesBill;

@Repository
public interface UtilitiesBillRepository extends JpaRepository<UtilitiesBill, Long>{
    List<UtilitiesBill> findByUser(User user);

    List<UtilitiesBill> findByUserId(Long userId);
}
