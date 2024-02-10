package com.project.estatemanagementsystem.service.impl.propertyimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Cash;
import com.project.estatemanagementsystem.repository.propertyrepository.CashRepository;
import com.project.estatemanagementsystem.service.propertyservice.CashService;

@Service
public class CashServiceImpl implements CashService{
    @Autowired
    private CashRepository cashRepository;

    @Override
    public List<Cash> getAllCashes(){
        return cashRepository.findAll();
    }

    @Override
    public List<Cash> getCashesByUser(User user){
        return cashRepository.findByUser(user);
    }

    @Override
    public List<Cash>getCashesByUserId(Long userId){
        return cashRepository.findByUserId(userId);
    }

    @Override
    public Cash saveCash(Cash cash){
        return cashRepository.save(cash);
    }

    @Override
    public Cash getCashById(Long id) {
        return cashRepository.findById(id).get();
    }

    @Override
    public Cash updateCash(Cash cash){
        Cash existingCash = getCashById(cash.getId());

        existingCash.setId(cash.getId());
        existingCash.setAccType(cash.getAccType());
        existingCash.setAccNumber(cash.getAccNumber());
        existingCash.setBankName(cash.getBankName());
        existingCash.setAmount(cash.getAmount());
        existingCash.setAccStatus(cash.getAccStatus());
        
        return cashRepository.save(existingCash);
    }

    @Override
    public void deleteCashById(Long id){
        cashRepository.deleteById(id);
    }
}
