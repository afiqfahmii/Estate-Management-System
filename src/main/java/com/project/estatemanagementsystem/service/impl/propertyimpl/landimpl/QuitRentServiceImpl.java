package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.QuitRent;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.QuitRentRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.QuitRentService;

@Service
public class QuitRentServiceImpl implements QuitRentService{
    @Autowired
    private QuitRentRepository quitRentRepository;

    @Override
    public List<QuitRent> getAllQuitRents(){
        return quitRentRepository.findAll();
    }

    @Override
    public List<QuitRent> getQuitRentsByUser(User user){
        return quitRentRepository.findByUser(user);
    }

    @Override
    public List<QuitRent>getQuitRentsByUserId(Long userId){
        return quitRentRepository.findByUserId(userId);
    }

    @Override
    public QuitRent saveQuitRent(QuitRent quitRent){
        return quitRentRepository.save(quitRent);
    }

    @Override
    public QuitRent getQuitRentById(Long id) {
        return quitRentRepository.findById(id).get();
    }

    @Override
    public QuitRent updateQuitRent(QuitRent quitRent){
        QuitRent existingQuitRent = getQuitRentById(quitRent.getId());

        existingQuitRent.setId(quitRent.getId());
        existingQuitRent.setTitleId(quitRent.getTitleId());
        existingQuitRent.setTax(quitRent.getTax());
        existingQuitRent.setState(quitRent.getState());
        existingQuitRent.setDistrict(quitRent.getDistrict());
        existingQuitRent.setAddress(quitRent.getAddress());
        existingQuitRent.setLotNumber(quitRent.getLotNumber());
        existingQuitRent.setArea(quitRent.getArea());
        existingQuitRent.setType(quitRent.getType());
        existingQuitRent.setRegDate(quitRent.getRegDate());
        existingQuitRent.setAccNumber(quitRent.getAccNumber());
        existingQuitRent.setYear(quitRent.getYear());
        existingQuitRent.setAmount(quitRent.getAmount());
        existingQuitRent.setPaymentDate(quitRent.getPaymentDate());
        existingQuitRent.setLotNumber(quitRent.getLotNumber());
        
        return quitRentRepository.save(existingQuitRent);
    }

    @Override
    public void deleteQuitRentById(Long id){
        quitRentRepository.deleteById(id);
    }
}
