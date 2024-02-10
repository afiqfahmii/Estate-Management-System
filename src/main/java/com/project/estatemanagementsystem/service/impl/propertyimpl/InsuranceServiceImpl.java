package com.project.estatemanagementsystem.service.impl.propertyimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Insurance;
import com.project.estatemanagementsystem.repository.propertyrepository.InsuranceRepository;
import com.project.estatemanagementsystem.service.propertyservice.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService{
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAllInsurances(){
        return insuranceRepository.findAll();
    }

    @Override
    public List<Insurance> getInsurancesByUser(User user){
        return insuranceRepository.findByUser(user);
    }

    @Override
    public List<Insurance>getInsurancesByUserId(Long userId){
        return insuranceRepository.findByUserId(userId);
    }

    @Override
    public Insurance saveInsurance(Insurance insurance){
        return insuranceRepository.save(insurance);
    }

    @Override
    public Insurance getInsuranceById(Long id) {
        return insuranceRepository.findById(id).get();
    }

    @Override
    public Insurance updateInsurance(Insurance insurance){
        Insurance existingInsurance = getInsuranceById(insurance.getId());

        existingInsurance.setId(insurance.getId());
        existingInsurance.setAmount(insurance.getAmount());
        existingInsurance.setMaturedDate(insurance.getMaturedDate());
        
        return insuranceRepository.save(existingInsurance);
    }

    @Override
    public void deleteInsuranceById(Long id){
        insuranceRepository.deleteById(id);
    }
}
