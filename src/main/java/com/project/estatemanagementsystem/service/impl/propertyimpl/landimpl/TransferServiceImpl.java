package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Transfer;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.TransferRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.TransferService;

@Service
public class TransferServiceImpl implements TransferService{
    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<Transfer> getAllTransfers(){
        return transferRepository.findAll();
    }

    @Override
    public List<Transfer> getTransfersByUser(User user){
        return transferRepository.findByUser(user);
    }

    @Override
    public List<Transfer>getTransfersByUserId(Long userId){
        return transferRepository.findByUserId(userId);
    }

    @Override
    public Transfer saveTransfer(Transfer transfer){
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer getTransferById(Long id) {
        return transferRepository.findById(id).get();
    }

    @Override
    public Transfer updateTransfer(Transfer transfer){
        Transfer existingTransfer = getTransferById(transfer.getId());

        existingTransfer.setId(transfer.getId());
        existingTransfer.setTitleId(transfer.getTitleId());
        existingTransfer.setTax(transfer.getTax());
        existingTransfer.setState(transfer.getState());
        existingTransfer.setDistrict(transfer.getDistrict());
        existingTransfer.setAddress(transfer.getAddress());
        existingTransfer.setLotNumber(transfer.getLotNumber());
        existingTransfer.setArea(transfer.getArea());
        existingTransfer.setType(transfer.getType());
        existingTransfer.setRegDate(transfer.getRegDate());
        
        return transferRepository.save(existingTransfer);
    }

    @Override
    public void deleteTransferById(Long id){
        transferRepository.deleteById(id);
    }
}
