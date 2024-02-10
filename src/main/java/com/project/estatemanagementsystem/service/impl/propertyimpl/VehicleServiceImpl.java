package com.project.estatemanagementsystem.service.impl.propertyimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Vehicle;
import com.project.estatemanagementsystem.repository.propertyrepository.VehicleRepository;
import com.project.estatemanagementsystem.service.propertyservice.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesByUser(User user){
        return vehicleRepository.findByUser(user);
    }

    @Override
    public List<Vehicle>getVehiclesByUserId(Long userId){
        return vehicleRepository.findByUserId(userId);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle){
        Vehicle existingVehicle = getVehicleById(vehicle.getId());

        existingVehicle.setId(vehicle.getId());
        existingVehicle.setCarRegNum(vehicle.getCarRegNum());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setTransactionDate(vehicle.getTransactionDate());
        existingVehicle.setBrand(vehicle.getBrand());
        existingVehicle.setCc(vehicle.getCc());
        existingVehicle.setInsuranceStartDate(vehicle.getInsuranceEndDate());
        existingVehicle.setInsuranceEndDate(vehicle.getInsuranceEndDate());
        existingVehicle.setInsuranceAmount(vehicle.getInsuranceAmount());
        existingVehicle.setRoadtaxStartDate(vehicle.getRoadtaxStartDate());
        existingVehicle.setRoadtaxEndDate(vehicle.getRoadtaxEndDate());
        existingVehicle.setRoadtaxAmount(vehicle.getRoadtaxAmount());
        
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicleById(Long id){
        vehicleRepository.deleteById(id);
    }
}
