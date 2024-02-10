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
        UtilitiesBill existingUtilitiesBill = getUtilitiesBillById(utilitiesBill.getId());

        existingUtilitiesBill.setId(utilitiesBill.getId());
        existingUtilitiesBill.setTitleId(utilitiesBill.getTitleId());
        existingUtilitiesBill.setTax(utilitiesBill.getTax());
        existingUtilitiesBill.setState(utilitiesBill.getState());
        existingUtilitiesBill.setDistrict(utilitiesBill.getDistrict());
        existingUtilitiesBill.setAddress(utilitiesBill.getAddress());
        existingUtilitiesBill.setLotNumber(utilitiesBill.getLotNumber());
        existingUtilitiesBill.setArea(utilitiesBill.getArea());
        existingUtilitiesBill.setType(utilitiesBill.getType());
        existingUtilitiesBill.setRegDate(utilitiesBill.getRegDate());
        existingUtilitiesBill.setBillNumber(utilitiesBill.getBillNumber());
        existingUtilitiesBill.setAccNumber(utilitiesBill.getAccNumber());
        existingUtilitiesBill.setBillOfMonth(utilitiesBill.getBillOfMonth());
        existingUtilitiesBill.setAmount(utilitiesBill.getBillOfMonth());
        existingUtilitiesBill.setBillOfYear(utilitiesBill.getBillOfYear());
        
        return utilitiesBillRepository.save(existingUtilitiesBill);
    }

    @Override
    public void deleteUtilitiesBillById(Long id){
        utilitiesBillRepository.deleteById(id);
    }
}
