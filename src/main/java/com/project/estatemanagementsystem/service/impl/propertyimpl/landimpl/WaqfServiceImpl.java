package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Waqf;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.WaqfRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.WaqfService;

@Service
public class WaqfServiceImpl implements WaqfService{
    @Autowired
    private WaqfRepository waqfRepository;

    @Override
    public List<Waqf> getAllWaqfs(){
        return waqfRepository.findAll();
    }

    @Override
    public List<Waqf> getWaqfsByUser(User user){
        return waqfRepository.findByUser(user);
    }

    @Override
    public List<Waqf>getWaqfsByUserId(Long userId){
        return waqfRepository.findByUserId(userId);
    }

    @Override
    public Waqf saveWaqf(Waqf waqf){
        return waqfRepository.save(waqf);
    }

    @Override
    public Waqf getWaqfById(Long id) {
        return waqfRepository.findById(id).get();
    }

    @Override
    public Waqf updateWaqf(Waqf waqf){
        return waqfRepository.save(waqf);
    }

    @Override
    public void deleteWaqfById(Long id){
        waqfRepository.deleteById(id);
    }
}
