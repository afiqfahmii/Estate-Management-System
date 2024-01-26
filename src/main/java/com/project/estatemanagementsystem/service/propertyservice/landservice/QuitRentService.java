package com.project.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.QuitRent;

public interface QuitRentService {
   List<QuitRent> getAllQuitRents();

	List<QuitRent> getQuitRentsByUser(User user);

	List<QuitRent> getQuitRentsByUserId(Long userId);
	
	QuitRent saveQuitRent(QuitRent quitRent);
	
	QuitRent getQuitRentById(Long id);
	
	QuitRent updateQuitRent(QuitRent quitRent);
	
	void deleteQuitRentById(Long id);    
}