package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.UtilitiesBill;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.UtilitiesBillRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.UtilitiesBillService;

@Service
public class UtilitiesBillServiceImpl implements UtilitiesBillService{
    @Autowired
    private UtilitiesBillRepository utilitiesBillRepository;

    @Override
    public List<UtilitiesBill> getAllUtilitiesBills(){
        return utilitiesBillRepository.findAll();
    }

    @Override
    public List<UtilitiesBill> getUtilitiesBillsByUser(User user){
        return utilitiesBillRepository.findByUser(user);
    }

    @Override
    public List<UtilitiesBill>getUtilitiesBillsByUserId(Long userId){
        return utilitiesBillRepository.findByUserId(userId);
    }

    @Override
    public UtilitiesBill saveUtilitiesBill(UtilitiesBill utilitiesBill){
        return utilitiesBillRepository.save(utilitiesBill);
    }

    @Override
    public UtilitiesBill getUtilitiesBillById(Long id) {
        return utilitiesBillRepository.findById(id).get();
    }

    @Override
    public UtilitiesBill updateUtilitiesBill(UtilitiesBill utilitiesBill){
        return utilitiesBillRepository.save(utilitiesBill);
    }

    @Override
    public void deleteUtilitiesBillById(Long id){
        utilitiesBillRepository.deleteById(id);
    }
}
