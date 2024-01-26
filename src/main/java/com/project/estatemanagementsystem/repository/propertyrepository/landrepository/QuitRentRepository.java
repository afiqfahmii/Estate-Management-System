package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.QuitRent;

@Repository
public interface QuitRentRepository extends JpaRepository<QuitRent, Long>{
    List<QuitRent> findByUser(User user);

    List<QuitRent> findByUserId(Long userId);
}
