package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Mortgage;

@Repository
public interface MortgageRepository extends JpaRepository<Mortgage, Long>{
    List<Mortgage> findByUser(User user);

    List<Mortgage> findByUserId(Long userId);
}
