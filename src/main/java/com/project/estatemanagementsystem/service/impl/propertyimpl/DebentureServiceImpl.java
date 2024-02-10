package com.project.estatemanagementsystem.service.impl.propertyimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Debenture;
import com.project.estatemanagementsystem.repository.propertyrepository.DebentureRepository;
import com.project.estatemanagementsystem.service.propertyservice.DebentureService;

@Service
public class DebentureServiceImpl implements DebentureService{
    @Autowired
    private DebentureRepository debentureRepository;

    @Override
    public List<Debenture> getAllDebentures(){
        return debentureRepository.findAll();
    }

    @Override
    public List<Debenture> getDebenturesByUser(User user){
        return debentureRepository.findByUser(user);
    }

    @Override
    public List<Debenture>getDebenturesByUserId(Long userId){
        return debentureRepository.findByUserId(userId);
    }

    @Override
    public Debenture saveDebenture(Debenture debenture){
        return debentureRepository.save(debenture);
    }

    @Override
    public Debenture getDebentureById(Long id) {
        return debentureRepository.findById(id).get();
    }

    @Override
    public Debenture updateDebenture(Debenture debenture){
        Debenture existingDebenture = getDebentureById(debenture.getId());

        existingDebenture.setId(debenture.getId());
        existingDebenture.setAgencyName(debenture.getAgencyName());
        existingDebenture.setAgencyAddress(debenture.getAgencyAddress());
        existingDebenture.setAmount(debenture.getAmount());
        existingDebenture.setShare(debenture.getShare());
        
        return debentureRepository.save(existingDebenture);
    }

    @Override
    public void deleteDebentureById(Long id){
        debentureRepository.deleteById(id);
    }
}
