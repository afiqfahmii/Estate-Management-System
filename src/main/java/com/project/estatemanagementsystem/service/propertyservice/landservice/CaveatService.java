package com.project.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Caveat;

public interface CaveatService {
    List<Caveat> getAllCaveats();

	List<Caveat> getCaveatsByUser(User user);

	List<Caveat> getCaveatsByUserId(Long userId);
	
	Caveat saveCaveat(Caveat caveat);
	
	Caveat getCaveatById(Long id);
	
	Caveat updateCaveat(Caveat Caveat);
	
	void deleteCaveatById(Long id);
}
