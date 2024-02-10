package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Easement;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.EasementRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.EasementService;

@Service
public class EasementServiceImpl implements EasementService {
    @Autowired
    private EasementRepository easementRepository;

    @Override
    public List<Easement> getAllEasements(){
        return easementRepository.findAll();
    }

    @Override
    public List<Easement> getEasementsByUser(User user){
        return easementRepository.findByUser(user);
    }

    @Override
    public List<Easement>getEasementsByUserId(Long userId){
        return easementRepository.findByUserId(userId);
    }

    @Override
    public Easement saveEasement(Easement easement){
        return easementRepository.save(easement);
    }

    @Override
    public Easement getEasementById(Long id) {
        return easementRepository.findById(id).get();
    }

    @Override
    public Easement updateEasement(Easement easement){
        Easement existingEasement = getEasementById(easement.getId());

        existingEasement.setId(easement.getId());
        existingEasement.setTitleId(easement.getTitleId());
        existingEasement.setTax(easement.getTax());
        existingEasement.setState(easement.getState());
        existingEasement.setDistrict(easement.getDistrict());
        existingEasement.setAddress(easement.getAddress());
        existingEasement.setLotNumber(easement.getLotNumber());
        existingEasement.setArea(easement.getArea());
        existingEasement.setType(easement.getType());
        existingEasement.setRegDate(easement.getRegDate());
        
        return easementRepository.save(existingEasement);
    }

    @Override
    public void deleteEasementById(Long id){
        easementRepository.deleteById(id);
    }

}
