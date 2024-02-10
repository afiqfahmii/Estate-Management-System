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
        Waqf existingWaqf = getWaqfById(waqf.getId());

        existingWaqf.setId(waqf.getId());
        existingWaqf.setTitleId(waqf.getTitleId());
        existingWaqf.setTax(waqf.getTax());
        existingWaqf.setState(waqf.getState());
        existingWaqf.setDistrict(waqf.getDistrict());
        existingWaqf.setAddress(waqf.getAddress());
        existingWaqf.setLotNumber(waqf.getLotNumber());
        existingWaqf.setArea(waqf.getArea());
        existingWaqf.setType(waqf.getType());
        existingWaqf.setRegDate(waqf.getRegDate());
        existingWaqf.setNazirName(waqf.getNazirName());
        existingWaqf.setNazirIdNumber(waqf.getNazirIdNumber());
        existingWaqf.setStatus(waqf.getStatus());
        
        return waqfRepository.save(existingWaqf);
    }

    @Override
    public void deleteWaqfById(Long id){
        waqfRepository.deleteById(id);
    }
}
