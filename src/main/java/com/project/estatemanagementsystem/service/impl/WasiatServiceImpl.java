package com.project.estatemanagementsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.estatemanagementsystem.dto.WasiatDto;
import com.project.estatemanagementsystem.entity.AdditionalWasiat;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.Wasiat;
import com.project.estatemanagementsystem.repository.AdditionalWasiatRepository;
import com.project.estatemanagementsystem.repository.WasiatRepository;
import com.project.estatemanagementsystem.repository.AdditionalWasiatRepository;
import com.project.estatemanagementsystem.service.WasiatService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class WasiatServiceImpl implements WasiatService {

    private final WasiatRepository wasiatRepository;
    private final AdditionalWasiatRepository awRepository;

    public WasiatServiceImpl(WasiatRepository wasiatRepository, AdditionalWasiatRepository awRepository) {
        this.wasiatRepository = wasiatRepository;
        this.awRepository = awRepository;
    }

    @Override
    public List<Wasiat> getWasiatByUser(User user) {
        return wasiatRepository.findByUser(user);
    }

    @Override
    public Wasiat saveWasiat(User user, String gender, String isteri, String suami, String anakLelaki,
            String anakPerempuan, String anakAngkat, String confirmation, String perbelanjaan, String anggaran,
            String hibah) {
        Wasiat wasiat = new Wasiat();
        wasiat.setUser(user);
        // wasiat.setContent(content);
        wasiat.setGender(gender);
        wasiat.setIsteri(isteri);
        wasiat.setSuami(suami);
        wasiat.setAnakLelaki(anakLelaki);
        wasiat.setAnakPerempuan(anakPerempuan);
        wasiat.setAnakAngkat(anakAngkat);
        wasiat.setConfirmation(confirmation);
        wasiat.setPerbelanjaan(perbelanjaan);
        wasiat.setAnggaran(anggaran);
        wasiat.setHibah(hibah);
        // You can set other properties like timestamp if needed
        return wasiatRepository.save(wasiat);
    }

    @Override
    public AdditionalWasiat saveAdditionalWasiat(User user, ArrayList<String> isteriName, ArrayList<String> anakLelakiName, ArrayList<String> anakPerempuanName, ArrayList<String> anakAngkatName){
        AdditionalWasiat aw = new AdditionalWasiat();
        aw.setUser(user);
        aw.setIsteriName(isteriName);
        aw.setAnakLelakiName(anakLelakiName);
        aw.setAnakPerempuanName(anakPerempuanName);
        aw.setAnakAngkatName(anakAngkatName);

        return awRepository.save(aw);
    }

    @Override
    public Wasiat findWasiatById(Long id) {
        return wasiatRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional // Ensure that the method is transactional
    public void updateWasiat(Long id, String content) {
        try {
            Wasiat existingWasiat = wasiatRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Wasiat not found for update."));

            // Null check for content
            if (content != null) {
                // existingWasiat.setContent(content);
                wasiatRepository.save(existingWasiat);
                System.out.println("Wasiat updated successfully.");
            } else {
                System.out.println("Content cannot be null for update.");
            }
        } catch (EntityNotFoundException e) {
            // Handle the exception (log, throw, or take appropriate action)
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
        // wasiatDto.setContent(wasiat.getContent());
        // You can map other properties if needed
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
        // Assuming your Wasiat entity has an 'id' field
        Long wasiatId = wasiat.getId();

        // Check if the Wasiat with the given id exists
        Optional<Wasiat> existingWasiat = wasiatRepository.findById(wasiatId);

        if (existingWasiat.isPresent()) {
            // Update the existing Wasiat with the new data
            Wasiat updatedWasiat = existingWasiat.get();
            // updatedWasiat.setContent(wasiat.getContent()); // Update other fields as
            // needed

            // Save the updated Wasiat
            wasiatRepository.save(updatedWasiat);
        } else {
            // Handle the case where the Wasiat with the given id is not found
            // You might want to throw an exception or handle it based on your requirements
            throw new EntityNotFoundException("Wasiat not found with id: " + wasiatId);
        }
    }
}
