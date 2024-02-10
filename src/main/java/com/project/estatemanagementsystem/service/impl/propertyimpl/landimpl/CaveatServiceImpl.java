package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Caveat;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.CaveatRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.CaveatService;

@Service
public class CaveatServiceImpl implements CaveatService{
    @Autowired
    private CaveatRepository caveatRepository;

    @Override
    public List<Caveat> getAllCaveats(){
        return caveatRepository.findAll();
    }

    @Override
    public List<Caveat> getCaveatsByUser(User user){
        return caveatRepository.findByUser(user);
    }

    @Override
    public List<Caveat>getCaveatsByUserId(Long userId){
        return caveatRepository.findByUserId(userId);
    }

    @Override
    public Caveat saveCaveat(Caveat caveat){
        return caveatRepository.save(caveat);
    }

    @Override
    public Caveat getCaveatById(Long id) {
        return caveatRepository.findById(id).get();
    }

    @Override
    public Caveat updateCaveat(Caveat caveat){
        Caveat existingCaveat = getCaveatById(caveat.getId());

        existingCaveat.setId(caveat.getId());
        existingCaveat.setTitleId(caveat.getTitleId());
        existingCaveat.setTax(caveat.getTax());
        existingCaveat.setState(caveat.getState());
        existingCaveat.setDistrict(caveat.getDistrict());
        existingCaveat.setAddress(caveat.getAddress());
        existingCaveat.setLotNumber(caveat.getLotNumber());
        existingCaveat.setArea(caveat.getArea());
        existingCaveat.setType(caveat.getType());
        existingCaveat.setRegDate(caveat.getRegDate());
        existingCaveat.setCaveatorName(caveat.getCaveatorName());
        existingCaveat.setCaveatorIdNumber(caveat.getCaveatorIdNumber());
        existingCaveat.setCaveatorAddress(caveat.getCaveatorAddress());
        
        return caveatRepository.save(existingCaveat);
    }

    @Override
    public void deleteCaveatById(Long id){
        caveatRepository.deleteById(id);
    }
}
