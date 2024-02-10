package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Mortgage;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.MortgageRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.MortgageService;

@Service
public class MortgageServiceImpl implements MortgageService{
    @Autowired
    private MortgageRepository mortgageRepository;

    @Override
    public List<Mortgage> getAllMortgages(){
        return mortgageRepository.findAll();
    }

    @Override
    public List<Mortgage> getMortgagesByUser(User user){
        return mortgageRepository.findByUser(user);
    }

    @Override
    public List<Mortgage>getMortgagesByUserId(Long userId){
        return mortgageRepository.findByUserId(userId);
    }

    @Override
    public Mortgage saveMortgage(Mortgage mortgage){
        return mortgageRepository.save(mortgage);
    }

    @Override
    public Mortgage getMortgageById(Long id) {
        return mortgageRepository.findById(id).get();
    }

    @Override
    public Mortgage updateMortgage(Mortgage mortgage){
        Mortgage existingMortgage = getMortgageById(mortgage.getId());

        existingMortgage.setId(mortgage.getId());
        existingMortgage.setTitleId(mortgage.getTitleId());
        existingMortgage.setTax(mortgage.getTax());
        existingMortgage.setState(mortgage.getState());
        existingMortgage.setDistrict(mortgage.getDistrict());
        existingMortgage.setAddress(mortgage.getAddress());
        existingMortgage.setLotNumber(mortgage.getLotNumber());
        existingMortgage.setArea(mortgage.getArea());
        existingMortgage.setType(mortgage.getType());
        existingMortgage.setRegDate(mortgage.getRegDate());
        existingMortgage.setAmount(mortgage.getAmount());
        existingMortgage.setMortgageeName(mortgage.getMortgageeName());
        existingMortgage.setMortgageeAddress(mortgage.getMortgageeAddress());
        existingMortgage.setMortgageStartDate(mortgage.getMortgageStartDate());
        existingMortgage.setMortgageEndDate(mortgage.getMortgageEndDate());
        
        return mortgageRepository.save(existingMortgage);
    }

    @Override
    public void deleteMortgageById(Long id){
        mortgageRepository.deleteById(id);
    }
}
