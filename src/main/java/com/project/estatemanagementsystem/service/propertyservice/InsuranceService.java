package com.project.estatemanagementsystem.service.propertyservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Insurance;

public interface InsuranceService {
    List<Insurance> getAllInsurances();

	List<Insurance> getInsurancesByUser(User user);

	List<Insurance> getInsurancesByUserId(Long userId);
	
	Insurance saveInsurance(Insurance insurance);
	
	Insurance getInsuranceById(Long id);
	
	Insurance updateInsurance(Insurance insurance);
	
	void deleteInsuranceById(Long id);
}
