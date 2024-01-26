package com.project.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Mortgage;

public interface MortgageService {
    List<Mortgage> getAllMortgages();

	List<Mortgage> getMortgagesByUser(User user);

	List<Mortgage> getMortgagesByUserId(Long userId);
	
	Mortgage saveMortgage(Mortgage mortgage);
	
	Mortgage getMortgageById(Long id);
	
	Mortgage updateMortgage(Mortgage mortgage);
	
	void deleteMortgageById(Long id);
}