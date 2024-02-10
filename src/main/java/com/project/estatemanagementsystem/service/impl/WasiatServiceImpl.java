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
import com.project.estatemanagementsystem.repository.UserRepository;
import com.project.estatemanagementsystem.repository.WasiatRepository;
import com.project.estatemanagementsystem.service.WasiatService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class WasiatServiceImpl implements WasiatService {

    private final WasiatRepository wasiatRepository;
    private final UserRepository userRepository;

    public WasiatServiceImpl(WasiatRepository wasiatRepository, UserRepository userRepository) {
        this.wasiatRepository = wasiatRepository;
        this.userRepository = userRepository;
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

        Optional<Wasiat> existingWasiat = wasiatRepository.findById(wasiatId);

        if (existingWasiat.isPresent()) {

            Wasiat updatedWasiat = existingWasiat.get();
            updatedWasiat.setGender(wasiat.getGender());
            updatedWasiat.setSuami(wasiat.getSuami());
            updatedWasiat.setIsteri(wasiat.getIsteri());
            updatedWasiat.setAnakAngkat(wasiat.getAnakAngkat());
            updatedWasiat.setAnakLelaki(wasiat.getAnakLelaki());
            updatedWasiat.setAnakPerempuan(wasiat.getAnakPerempuan());
            updatedWasiat.setAnggaran(wasiat.getAnggaran());

            updatedWasiat.setPerbelanjaan(wasiat.getPerbelanjaan());
            updatedWasiat.setHibah(wasiat.getHibah());
            updatedWasiat.setAnakLelakiDetails(wasiat.getAnakLelakiDetails());
            updatedWasiat.setAnakPerempuanDetails(wasiat.getAnakPerempuanDetails());
            updatedWasiat.setAnakAngkatDetails(wasiat.getAnakAngkatDetails());
            updatedWasiat.setIsteriDetails(wasiat.getIsteriDetails());
            updatedWasiat.setSuamiDetails(wasiat.getSuamiDetails());
            List<AnakLelakiDetail> updatedAnakLelakiNames = wasiat.getAnakLelakiDetails();
            List<AnakLelakiDetail> existingAnakLelakiNames = updatedWasiat.getAnakLelakiDetails();
            List<AnakPerempuanDetail> updatedAnakPerempuanDetails = wasiat.getAnakPerempuanDetails();
            List<AnakPerempuanDetail> existingAnakPerempuanDetails = updatedWasiat.getAnakPerempuanDetails();
            List<AnakAngkatDetail> updatedAnakAngkatDetails = wasiat.getAnakAngkatDetails();
            List<AnakAngkatDetail> existingAnakAngkatDetails = updatedWasiat.getAnakAngkatDetails();
            List<IsteriDetail> updatedIsteriDetails = wasiat.getIsteriDetails();
            List<IsteriDetail> existingIsteriDetails = updatedWasiat.getIsteriDetails();
            List<SuamiDetail> updatedSuamiDetails = wasiat.getSuamiDetails();
            List<SuamiDetail> existingSuamiDetails = updatedWasiat.getSuamiDetails();

            // Update the existing anakLelakiNames with the new values
            for (int i = 0; i < existingAnakLelakiNames.size(); i++) {
                AnakLelakiDetail updatedAnakLelaki = updatedAnakLelakiNames.get(i);
                AnakLelakiDetail existingAnakLelaki = existingAnakLelakiNames.get(i);

                existingAnakLelaki.setName(updatedAnakLelaki.getName());
                existingAnakLelaki.setIc(updatedAnakLelaki.getIc());
                existingAnakLelaki.setOku(updatedAnakLelaki.getOku());
            }
            for (int i = 0; i < existingAnakPerempuanDetails.size(); i++) {
                AnakPerempuanDetail updatedAnakPerempuan = updatedAnakPerempuanDetails.get(i);
                AnakPerempuanDetail existingAnakPerempuan = existingAnakPerempuanDetails.get(i);

                existingAnakPerempuan.setName(updatedAnakPerempuan.getName());
                existingAnakPerempuan.setIc(updatedAnakPerempuan.getIc());
                existingAnakPerempuan.setOku(updatedAnakPerempuan.getOku());
            }
            for (int i = 0; i < existingAnakAngkatDetails.size(); i++) {
                AnakAngkatDetail updatedAnakAngkat = updatedAnakAngkatDetails.get(i);
                AnakAngkatDetail existingAnakAngkat = existingAnakAngkatDetails.get(i);

                existingAnakAngkat.setName(updatedAnakAngkat.getName());
                existingAnakAngkat.setIc(updatedAnakAngkat.getIc());
                existingAnakAngkat.setOku(updatedAnakAngkat.getOku());
            }
            for (int i = 0; i < existingIsteriDetails.size(); i++) {
                IsteriDetail updatedIsteri = updatedIsteriDetails.get(i);
                IsteriDetail existingIsteri = existingIsteriDetails.get(i);

                existingIsteri.setName(updatedIsteri.getName());
                existingIsteri.setIc(updatedIsteri.getIc());

            }
            for (int i = 0; i < existingSuamiDetails.size(); i++) {
                SuamiDetail updatedSuami = updatedSuamiDetails.get(i);
                SuamiDetail existingSuami = existingSuamiDetails.get(i);

                existingSuami.setName(updatedSuami.getName());
                existingSuami.setIc(updatedSuami.getIc());

            }

            wasiatRepository.save(updatedWasiat);
        }

    }

    // @Override
    // public Wasiat getWasiatDetailsByUserId(Long userId) {
    //     Optional<User> userOptional = userRepository.findById(userId);

    //     if (userOptional.isPresent()) {
    //         User user = userOptional.get();
    //         // Wasiat wasiat = user.getWasiat();
    //         List<Wasiat> wasiatList = wasiatRepository.findAll();

    //         for (Wasiat wasiat : wasiatList) {
    //             if (isMatchingIc(user.getIDNum(), wasiat)) {
    //                 return wasiat;
    //             }
    //         }
    //     }

    //     return null;
    // }

    @Override
    public User getWasiatDetailsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Wasiat wasiat = user.getWasiat();
            List<Wasiat> wasiatList = wasiatRepository.findAll();

            for (Wasiat wasiat : wasiatList) {
                if (isMatchingIc(user.getIDNum(), wasiat)) {
                    User parent = new User();
                    
                    parent = wasiat.getUser();
                    return parent;
                }else if(isMatchingUser(user.getId(), wasiat)){
                    return user;
                }
            }
        }

        return null;
    }

    private boolean isMatchingIc(String userIdNum, Wasiat wasiat) {
        // Check AnakLelaki
        if (isMatchingIcInList(userIdNum, wasiat.getAnakLelakiDetails())) {
            return true;
        }

        // Check AnakPerempuan
        if (isMatchingIcInList(userIdNum, wasiat.getAnakPerempuanDetails())) {
            return true;
        }

        // Check AnakAngkat
        if (isMatchingIcInList(userIdNum, wasiat.getAnakAngkatDetails())) {
            return true;
        }

        // Check Isteri
        if (isMatchingIcInList(userIdNum, wasiat.getIsteriDetails())) {
            return true;
        }

        // Check Suami
        if (isMatchingIcInList(userIdNum, wasiat.getSuamiDetails())) {
            return true;
        }

        return false;
    }

    private boolean isMatchingIcInList(String userIdNum, List<?> details) {
        for (Object detail : details) {
            if (detail instanceof AnakLelakiDetail) {
                AnakLelakiDetail anakLelaki = (AnakLelakiDetail) detail;
                if (userIdNum.equals(anakLelaki.getIc())) {
                    return true;
                }
            } else if (detail instanceof AnakPerempuanDetail) {
                AnakPerempuanDetail anakPerempuan = (AnakPerempuanDetail) detail;
                if (userIdNum.equals(anakPerempuan.getIc())) {
                    return true;
                }
            } else if (detail instanceof AnakAngkatDetail) {
                AnakAngkatDetail anakAngkat = (AnakAngkatDetail) detail;
                if (userIdNum.equals(anakAngkat.getIc())) {
                    return true;
                }
            } else if (detail instanceof IsteriDetail) {
                IsteriDetail isteri = (IsteriDetail) detail;
                if (userIdNum.equals(isteri.getIc())) {
                    return true;
                }
            } else if (detail instanceof SuamiDetail) {
                SuamiDetail suami = (SuamiDetail) detail;
                if (userIdNum.equals(suami.getIc())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMatchingUser(Long userId, Wasiat wasiat){
        User user = wasiat.getUser();
        if(userId.equals(user.getId())) {
            return true;
        }

        return false;
    }

}
