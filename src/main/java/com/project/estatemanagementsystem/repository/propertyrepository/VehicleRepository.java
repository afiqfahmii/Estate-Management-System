package com.project.estatemanagementsystem.repository.propertyrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    List<Vehicle> findByUser(User user);

    List<Vehicle> findByUserId(Long userId);
}
