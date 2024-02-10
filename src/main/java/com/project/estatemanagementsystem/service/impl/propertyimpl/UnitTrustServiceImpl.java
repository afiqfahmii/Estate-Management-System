package com.project.estatemanagementsystem.service.impl.propertyimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.UnitTrust;
import com.project.estatemanagementsystem.repository.propertyrepository.UnitTrustRepository;
import com.project.estatemanagementsystem.service.propertyservice.UnitTrustService;

@Service
public class UnitTrustServiceImpl implements UnitTrustService{
    @Autowired
    private UnitTrustRepository unitTrustRepository;

    @Override
    public List<UnitTrust> getAllUnitTrusts(){
        return unitTrustRepository.findAll();
    }

    @Override
    public List<UnitTrust> getUnitTrustsByUser(User user){
        return unitTrustRepository.findByUser(user);
    }

    @Override
    public List<UnitTrust>getUnitTrustsByUserId(Long userId){
        return unitTrustRepository.findByUserId(userId);
    }

    @Override
    public UnitTrust saveUnitTrust(UnitTrust unitTrust){
        return unitTrustRepository.save(unitTrust);
    }

    @Override
    public UnitTrust getUnitTrustById(Long id) {
        return unitTrustRepository.findById(id).get();
    }

    @Override
    public UnitTrust updateUnitTrust(UnitTrust unitTrust){
        UnitTrust existingUnitTrust = getUnitTrustById(unitTrust.getId());

        existingUnitTrust.setId(unitTrust.getId());
        existingUnitTrust.setAmount(unitTrust.getAmount());
        existingUnitTrust.setMaturedDate(unitTrust.getMaturedDate());
        
        return unitTrustRepository.save(existingUnitTrust);
    }

    @Override
    public void deleteUnitTrustById(Long id){
        unitTrustRepository.deleteById(id);
    }
}
