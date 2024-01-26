package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Charge;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.ChargeRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService{
    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public List<Charge> getAllCharges(){
        return chargeRepository.findAll();
    }

    @Override
    public List<Charge> getChargesByUser(User user){
        return chargeRepository.findByUser(user);
    }

    @Override
    public List<Charge>getChargesByUserId(Long userId){
        return chargeRepository.findByUserId(userId);
    }

    @Override
    public Charge saveCharge(Charge charge){
        return chargeRepository.save(charge);
    }

    @Override
    public Charge getChargeById(Long id) {
        return chargeRepository.findById(id).get();
    }

    @Override
    public Charge updateCharge(Charge charge){
        return chargeRepository.save(charge);
    }

    @Override
    public void deleteChargeById(Long id){
        chargeRepository.deleteById(id);
    }

}
