package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Lease;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.LeaseRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.LeaseService;

@Service
public class LeaseServiceImpl implements LeaseService{
    @Autowired
    private LeaseRepository leaseRepository;

    @Override
    public List<Lease> getAllLeases(){
        return leaseRepository.findAll();
    }

    @Override
    public List<Lease> getLeasesByUser(User user){
        return leaseRepository.findByUser(user);
    }

    @Override
    public List<Lease>getLeasesByUserId(Long userId){
        return leaseRepository.findByUserId(userId);
    }

    @Override
    public Lease saveLease(Lease lease){
        return leaseRepository.save(lease);
    }

    @Override
    public Lease getLeaseById(Long id) {
        return leaseRepository.findById(id).get();
    }

    @Override
    public Lease updateLease(Lease lease){
        Lease existingLease = getLeaseById(lease.getId());

        existingLease.setId(lease.getId());
        existingLease.setTitleId(lease.getTitleId());
        existingLease.setTax(lease.getTax());
        existingLease.setState(lease.getState());
        existingLease.setDistrict(lease.getDistrict());
        existingLease.setAddress(lease.getAddress());
        existingLease.setLotNumber(lease.getLotNumber());
        existingLease.setArea(lease.getArea());
        existingLease.setType(lease.getType());
        existingLease.setRegDate(lease.getRegDate());
        existingLease.setLesserName(lease.getLesserName());
        existingLease.setLesserIdNumber(lease.getLesserIdNumber());
        existingLease.setStartDate(lease.getStartDate());
        existingLease.setEndDate(lease.getEndDate());
        
        return leaseRepository.save(existingLease);
    }

    @Override
    public void deleteLeaseById(Long id){
        leaseRepository.deleteById(id);
    }

}
