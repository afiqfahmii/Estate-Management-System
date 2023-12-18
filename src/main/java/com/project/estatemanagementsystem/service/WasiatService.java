package com.project.estatemanagementsystem.service;

import java.util.List;

import com.project.estatemanagementsystem.dto.WasiatDto;
import com.project.estatemanagementsystem.entity.Wasiat;
import com.project.estatemanagementsystem.entity.User;
// import com.project.estatemanagementsystem.dto.WasiatDto;

public interface WasiatService {

    List<Wasiat> getWasiatByUser(User user);

    Wasiat saveWasiat(User user, String gender, String isteri, String suami, String anakLelaki, String anakPerempuan, String anakAngkat, String confirmation, String perbelanjaan, String anggaran, String hibah);

    Wasiat findWasiatById(Long id);

    void updateWasiat(Long id, String content);

    void deleteWasiat(Long id);

    void deleteUserWasiat(Long userId);

    List<WasiatDto> getAllWasiat();

    Wasiat getWasiatByUserId(Long userId);

    void updateWasiat(WasiatDto wasiat);

    
}
