package com.project.estatemanagementsystem.repository.propertyrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Debenture;

@Repository
public interface DebentureRepository extends JpaRepository<Debenture, Long>{
    List<Debenture> findByUser(User user);

    List<Debenture> findByUserId(Long userId);
}
