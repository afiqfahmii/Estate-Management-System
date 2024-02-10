package com.project.estatemanagementsystem.service.impl.propertyimpl.landimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Tenancy;
import com.project.estatemanagementsystem.repository.propertyrepository.landrepository.TenancyRepository;
import com.project.estatemanagementsystem.service.propertyservice.landservice.TenancyService;

@Service
public class TenancyServiceImpl implements TenancyService {
    @Autowired
    private TenancyRepository tenancyRepository;

    @Override
    public List<Tenancy> getAllTenancies(){
        return tenancyRepository.findAll();
    }

    @Override
    public List<Tenancy> getTenanciesByUser(User user){
        return tenancyRepository.findByUser(user);
    }

    @Override
    public List<Tenancy>getTenanciesByUserId(Long userId){
        return tenancyRepository.findByUserId(userId);
    }

    @Override
    public Tenancy saveTenancy(Tenancy tenancy){
        return tenancyRepository.save(tenancy);
    }

    @Override
    public Tenancy getTenancyById(Long id) {
        return tenancyRepository.findById(id).get();
    }

    @Override
    public Tenancy updateTenancy(Tenancy tenancy){
        Tenancy existingTenancy = getTenancyById(tenancy.getId());

        existingTenancy.setId(tenancy.getId());
        existingTenancy.setTitleId(tenancy.getTitleId());
        existingTenancy.setTax(tenancy.getTax());
        existingTenancy.setState(tenancy.getState());
        existingTenancy.setDistrict(tenancy.getDistrict());
        existingTenancy.setAddress(tenancy.getAddress());
        existingTenancy.setLotNumber(tenancy.getLotNumber());
        existingTenancy.setArea(tenancy.getArea());
        existingTenancy.setType(tenancy.getType());
        existingTenancy.setRegDate(tenancy.getRegDate());
        existingTenancy.setTenantName(tenancy.getTenantName());
        existingTenancy.setTenantIdNumber(tenancy.getTenantIdNumber());
        existingTenancy.setStartDate(tenancy.getStartDate());
        existingTenancy.setEndDate(tenancy.getEndDate());
        
        return tenancyRepository.save(existingTenancy);
    }

    @Override
    public void deleteTenancyById(Long id){
        tenancyRepository.deleteById(id);
    }
}
