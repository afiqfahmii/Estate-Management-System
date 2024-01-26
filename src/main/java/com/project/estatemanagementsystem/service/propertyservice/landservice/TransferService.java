package com.project.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Transfer;

public interface TransferService {
    List<Transfer> getAllTransfers();

	List<Transfer> getTransfersByUser(User user);

	List<Transfer> getTransfersByUserId(Long userId);
	
	Transfer saveTransfer(Transfer transfer);
	
	Transfer getTransferById(Long id);
	
	Transfer updateTransfer(Transfer transfer);
	
	void deleteTransferById(Long id);
}
