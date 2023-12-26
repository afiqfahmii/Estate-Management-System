package com.project.estatemanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.estatemanagementsystem.dto.WasiatDto;
import com.project.estatemanagementsystem.entity.AnakAngkatDetail;
import com.project.estatemanagementsystem.entity.AnakLelakiDetail;
import com.project.estatemanagementsystem.entity.AnakPerempuanDetail;
import com.project.estatemanagementsystem.entity.IsteriDetail;
import com.project.estatemanagementsystem.entity.SuamiDetail;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.Wasiat;
import com.project.estatemanagementsystem.repository.WasiatRepository;
import com.project.estatemanagementsystem.service.WasiatService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class WasiatServiceImpl implements WasiatService {

    private final WasiatRepository wasiatRepository;

    public WasiatServiceImpl(WasiatRepository wasiatRepository) {
        this.wasiatRepository = wasiatRepository;
    }

    @Override
    public List<Wasiat> getWasiatByUser(User user) {
        return wasiatRepository.findByUser(user);
    }

    @Override
    public Wasiat saveWasiat(Wasiat wasiat) {
        return wasiatRepository.save(wasiat);
    }

    @Override
    public Wasiat findWasiatById(Long id) {
        return wasiatRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateWasiat(Long id, String content) {
        try {
            Wasiat existingWasiat = wasiatRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Wasiat not found for update."));

            if (content != null) {
                wasiatRepository.save(existingWasiat);
                System.out.println("Wasiat updated successfully.");
            } else {
                System.out.println("Content cannot be null for update.");
            }
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWasiat(Long id) {
        wasiatRepository.deleteById(id);
    }

    // ? Admin-------------------------------------------------------------------

    @Override
    public List<WasiatDto> getAllWasiat() {
        List<Wasiat> wasiatList = wasiatRepository.findAll();
        return wasiatList.stream().map((wasiat) -> convertEntityToDto(wasiat))
                .collect(Collectors.toList());
    }

    private WasiatDto convertEntityToDto(Wasiat wasiat) {
        WasiatDto wasiatDto = new WasiatDto();
        wasiatDto.setUser(wasiat.getUser());

        return wasiatDto;
    }

    @Override
    public void deleteUserWasiat(Long userId) {
        wasiatRepository.deleteByUserId(userId);
    }

    
    // ?edit
    @Override
    public Wasiat getWasiatByUserId(Long userId) {
        return wasiatRepository.findByUserId(userId);
    }

    @Override
public void updateWasiat(Wasiat wasiat) {
    Long wasiatId = wasiat.getId();

    Optional<Wasiat> existingWasiatOptional = wasiatRepository.findById(wasiatId);

    if (existingWasiatOptional.isPresent()) {
        Wasiat existingWasiat = existingWasiatOptional.get();

        existingWasiat.setGender(wasiat.getGender());
        existingWasiat.setSuami(wasiat.getSuami());
        existingWasiat.setIsteri(wasiat.getIsteri());
        existingWasiat.setAnakAngkat(wasiat.getAnakAngkat());
        existingWasiat.setAnakLelaki(wasiat.getAnakLelaki());
        existingWasiat.setAnakPerempuan(wasiat.getAnakPerempuan());
        existingWasiat.setAnggaran(wasiat.getAnggaran());
        existingWasiat.setPerbelanjaan(wasiat.getPerbelanjaan());
        existingWasiat.setHibah(wasiat.getHibah());

        existingWasiat.setAnakLelakiDetails(wasiat.getAnakLelakiDetails());
        existingWasiat.setAnakPerempuanDetails(wasiat.getAnakPerempuanDetails());
        existingWasiat.setAnakAngkatDetails(wasiat.getAnakAngkatDetails());
        existingWasiat.setIsteriDetails(wasiat.getIsteriDetails());
        existingWasiat.setSuamiDetails(wasiat.getSuamiDetails());

        List<AnakLelakiDetail> updatedAnakLelakiDetail = wasiat.getAnakLelakiDetails();
        List<AnakLelakiDetail> existingAnakLelakiDetail = existingWasiat.getAnakLelakiDetails();

        List<AnakPerempuanDetail> updatedAnakPerempuanDetail = wasiat.getAnakPerempuanDetails();
        List<AnakPerempuanDetail> existingAnakPerempuanDetail = existingWasiat.getAnakPerempuanDetails();

        List<AnakAngkatDetail> updatedAnakAngkatDetail = wasiat.getAnakAngkatDetails();
        List<AnakAngkatDetail> existingAnakAngkatDetail = existingWasiat.getAnakAngkatDetails();

        List <IsteriDetail> existingIsteriDetail = wasiat.getIsteriDetails();
        List <IsteriDetail> updatedIsteriDetail = existingWasiat.getIsteriDetails();
        
        List <SuamiDetail> existingSuamiDetail = wasiat.getSuamiDetails();
        List <SuamiDetail> updatedSuamiDetail = existingWasiat.getSuamiDetails();

        for (int i = 0; i < existingAnakLelakiDetail.size(); i++) {
            AnakLelakiDetail updatedAnakLelaki = updatedAnakLelakiDetail.get(i);
            AnakLelakiDetail existingAnakLelaki = existingAnakLelakiDetail.get(i);

            existingAnakLelaki.setName(updatedAnakLelaki.getName());
            existingAnakLelaki.setIc(updatedAnakLelaki.getIc());
            existingAnakLelaki.setOku(updatedAnakLelaki.getOku());
        }

        for (int i = 0; i < existingAnakPerempuanDetail.size(); i++) {
            AnakPerempuanDetail updatedAnakPerempuan = updatedAnakPerempuanDetail.get(i);
            AnakPerempuanDetail existingAnakPerempuan = existingAnakPerempuanDetail.get(i);

            existingAnakPerempuan.setName(updatedAnakPerempuan.getName());
            existingAnakPerempuan.setIc(updatedAnakPerempuan.getIc());
            existingAnakPerempuan.setOku(updatedAnakPerempuan.getOku());
        }

        for (int i = 0; i < existingAnakAngkatDetail.size(); i++) {
            AnakAngkatDetail updatedAnakAngkat = updatedAnakAngkatDetail.get(i);
            AnakAngkatDetail existingAnakAngkat = existingAnakAngkatDetail.get(i);

            existingAnakAngkat.setName(updatedAnakAngkat.getName());
            existingAnakAngkat.setIc(updatedAnakAngkat.getIc());
            existingAnakAngkat.setOku(updatedAnakAngkat.getOku());
        }

        for (int i = 0; i < existingIsteriDetail.size(); i++) {
            IsteriDetail updatedIsteri = updatedIsteriDetail.get(i);
            IsteriDetail existingIsteri = existingIsteriDetail.get(i);

            existingIsteri.setName(updatedIsteri.getName());
            existingIsteri.setIc(updatedIsteri.getIc());

        }

        for (int i = 0; i < existingSuamiDetail.size(); i++) {
            SuamiDetail updatedSuami = updatedSuamiDetail.get(i);
            SuamiDetail existingSuami = existingSuamiDetail.get(i);

            existingSuami.setName(updatedSuami.getName());
            existingSuami.setIc(updatedSuami.getIc());

        }

        wasiatRepository.save(existingWasiat);
    }
}


}
