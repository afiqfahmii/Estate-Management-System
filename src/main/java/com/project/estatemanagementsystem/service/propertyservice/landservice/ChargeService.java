package com.project.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Charge;

public interface ChargeService {
    List<Charge> getAllCharges();

	List<Charge> getChargesByUser(User user);

	List<Charge> getChargesByUserId(Long userId);
	
	Charge saveCharge(Charge charge);
	
	Charge getChargeById(Long id);
	
	Charge updateCharge(Charge charge);
	
	void deleteChargeById(Long id);
}
