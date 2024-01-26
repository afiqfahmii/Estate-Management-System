package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Maintenance;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.MaintenanceRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.MaintenanceService;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public List<Maintenance> getAllMaintenances(){
        return maintenanceRepository.findAll();
    }

    @Override
    public List<Maintenance> getMaintenancesByUser(User user){
        return maintenanceRepository.findByUser(user);
    }

    @Override
    public List<Maintenance>getMaintenancesByUserId(Long userId){
        return maintenanceRepository.findByUserId(userId);
    }

    @Override
    public Maintenance saveMaintenance(Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id).get();
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void deleteMaintenanceById(Long id){
        maintenanceRepository.deleteById(id);
    }
}
