package com.project.estatemanagementsystem.service.impl.propertyimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Bond;
import com.project.estatemanagementsystem.repository.propertyrepository.BondRepository;
import com.project.estatemanagementsystem.service.propertyservice.BondService;

@Service
public class BondServiceImpl implements BondService{
    @Autowired
    private BondRepository bondRepository;

    @Override
    public List<Bond> getAllBonds(){
        return bondRepository.findAll();
    }

    @Override
    public List<Bond> getBondsByUser(User user){
        return bondRepository.findByUser(user);
    }

    @Override
    public List<Bond>getBondsByUserId(Long userId){
        return bondRepository.findByUserId(userId);
    }

    @Override
    public Bond saveBond(Bond bond){
        return bondRepository.save(bond);
    }

    @Override
    public Bond getBondById(Long id) {
        return bondRepository.findById(id).orElse(null);
    }

    @Override
    public Bond updateBond(Bond bond){
        Bond existingBond = getBondById(bond.getId());

        existingBond.setId(bond.getId());
        existingBond.setAgencyName(bond.getAgencyName());
        existingBond.setAgencyAddress(bond.getAgencyAddress());
        existingBond.setAmount(bond.getAmount());
        existingBond.setShare(bond.getShare());
        
        return bondRepository.save(existingBond);
    }

    @Override
    public void deleteBondById(Long id){
        bondRepository.deleteById(id);
    }


}
