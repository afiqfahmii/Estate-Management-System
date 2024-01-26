package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.property.land.Caveat;
import com.project.estatemanagementsystem.entity.User;



@Repository
public interface CaveatRepository extends JpaRepository<Caveat, Long>{
    List<Caveat> findByUser(User user);

    List<Caveat> findByUserId(Long userId);
}
