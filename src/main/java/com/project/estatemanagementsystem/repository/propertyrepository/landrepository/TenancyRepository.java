package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Tenancy;

@Repository
public interface TenancyRepository extends JpaRepository<Tenancy, Long>{
    List<Tenancy> findByUser(User user);

    List<Tenancy> findByUserId(Long userId);
}
