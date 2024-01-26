package com.project.estatemanagementsystem.service.propertyservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Cash;

public interface CashService {
    List<Cash> getAllCashes();

	List<Cash> getCashesByUser(User user);

	List<Cash> getCashesByUserId(Long userId);
	
	Cash saveCash(Cash cash);
	
	Cash getCashById(Long id);
	
	Cash updateCash(Cash cash);
	
	void deleteCashById(Long id);
}
