package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Waqf;

@Repository
public interface WaqfRepository extends JpaRepository<Waqf, Long>{
    List<Waqf> findByUser(User user);

    List<Waqf> findByUserId(Long userId);
}
