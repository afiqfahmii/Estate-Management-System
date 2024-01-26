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
        return tenancyRepository.save(tenancy);
    }

    @Override
    public void deleteTenancyById(Long id){
        tenancyRepository.deleteById(id);
    }
}
