package com.project.estatemanagementsystem.service.impl.propertyimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Share;
import com.project.estatemanagementsystem.repository.propertyrepository.ShareRepository;
import com.project.estatemanagementsystem.service.propertyservice.ShareService;

@Service
public class ShareServiceImpl implements ShareService{
    @Autowired
    private ShareRepository shareRepository;

    @Override
    public List<Share> getAllShares(){
        return shareRepository.findAll();
    }

    @Override
    public List<Share> getSharesByUser(User user){
        return shareRepository.findByUser(user);
    }

    @Override
    public List<Share>getSharesByUserId(Long userId){
        return shareRepository.findByUserId(userId);
    }

    @Override
    public Share saveShare(Share share){
        return shareRepository.save(share);
    }

    @Override
    public Share getShareById(Long id) {
        return shareRepository.findById(id).get();
    }

    @Override
    public Share updateShare(Share share){
        Share existingShare = getShareById(share.getId());

        existingShare.setId(share.getId());
        existingShare.setAgencyName(share.getAgencyName());
        existingShare.setAgencyAddress(share.getAgencyAddress());
        existingShare.setAmount(share.getAmount());
        existingShare.setShare(share.getShare());
        
        return shareRepository.save(existingShare);
    }

    @Override
    public void deleteShareById(Long id){
        shareRepository.deleteById(id);
    }
}
