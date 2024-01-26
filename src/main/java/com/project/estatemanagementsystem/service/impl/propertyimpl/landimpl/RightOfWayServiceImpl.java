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
        return rightOfWayRepository.save(rightOfWay);
    }

    @Override
    public void deleteRightOfWayById(Long id){
        rightOfWayRepository.deleteById(id);
    }
}
