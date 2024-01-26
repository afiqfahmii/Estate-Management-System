package com.project.estatemanagementsystem.repository.propertyrepository.landrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Lease;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long>{
    List<Lease> findByUser(User user);

    List<Lease> findByUserId(Long userId);
}
