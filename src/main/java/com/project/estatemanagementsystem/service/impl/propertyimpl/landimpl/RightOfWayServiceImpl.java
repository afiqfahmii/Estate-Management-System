package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.RightOfWay;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.RightOfWayRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.RightOfWayService;

@Service
public class RightOfWayServiceImpl implements RightOfWayService{
    @Autowired
    private RightOfWayRepository rightOfWayRepository;

    @Override
    public List<RightOfWay> getAllRightOfWays(){
        return rightOfWayRepository.findAll();
    }

    @Override
    public List<RightOfWay> getRightOfWaysByUser(User user){
        return rightOfWayRepository.findByUser(user);
    }

    @Override
    public List<RightOfWay>getRightOfWaysByUserId(Long userId){
        return rightOfWayRepository.findByUserId(userId);
    }

    @Override
    public RightOfWay saveRightOfWay(RightOfWay rightOfWay){
        return rightOfWayRepository.save(rightOfWay);
    }

    @Override
    public RightOfWay getRightOfWayById(Long id) {
        return rightOfWayRepository.findById(id).get();
    }

    @Override
    public RightOfWay updateRightOfWay(RightOfWay rightOfWay){
        RightOfWay existingRightOfWay = getRightOfWayById(rightOfWay.getId());

        existingRightOfWay.setId(rightOfWay.getId());
        existingRightOfWay.setTitleId(rightOfWay.getTitleId());
        existingRightOfWay.setTax(rightOfWay.getTax());
        existingRightOfWay.setState(rightOfWay.getState());
        existingRightOfWay.setDistrict(rightOfWay.getDistrict());
        existingRightOfWay.setAddress(rightOfWay.getAddress());
        existingRightOfWay.setLotNumber(rightOfWay.getLotNumber());
        existingRightOfWay.setArea(rightOfWay.getArea());
        existingRightOfWay.setType(rightOfWay.getType());
        existingRightOfWay.setRegDate(rightOfWay.getRegDate());

        return rightOfWayRepository.save(existingRightOfWay);
    }

    @Override
    public void deleteRightOfWayById(Long id){
        rightOfWayRepository.deleteById(id);
    }
}
