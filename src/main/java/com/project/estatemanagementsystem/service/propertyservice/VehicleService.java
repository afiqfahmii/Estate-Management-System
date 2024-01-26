package com.project.estatemanagementsystem.service.propertyservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Vehicle;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

	List<Vehicle> getVehiclesByUser(User user);

	List<Vehicle> getVehiclesByUserId(Long userId);
	
	Vehicle saveVehicle(Vehicle vehicle);
	
	Vehicle getVehicleById(Long id);
	
	Vehicle updateVehicle(Vehicle vehicle);
	
	void deleteVehicleById(Long id);
}
