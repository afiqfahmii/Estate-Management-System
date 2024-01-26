package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long>{
    List<Maintenance> findByUser(User user);

    List<Maintenance> findByUserId(Long userId);
}
