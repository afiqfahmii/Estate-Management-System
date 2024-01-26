package com.project.estatemanagementsystem.repository.propertyrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Share;

@Repository
public interface ShareRepository extends JpaRepository<Share, Long>{
    List<Share> findByUser(User user);

    List<Share> findByUserId(Long userId);
}
