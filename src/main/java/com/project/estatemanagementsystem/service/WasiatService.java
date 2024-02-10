package com.project.estatemanagementsystem.service;

import java.util.List;

import com.project.estatemanagementsystem.dto.WasiatDto;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.Wasiat;

public interface WasiatService {

    List<Wasiat> getWasiatByUser(User user);

    Wasiat saveWasiat(Wasiat wasiat);

    Wasiat findWasiatById(Long id);

    void updateWasiat(Long id, String content);

    void deleteWasiat(Long id);

    void deleteUserWasiat(Long userId);

    List<WasiatDto> getAllWasiat();

    Wasiat getWasiatByUserId(Long userId);

    void updateWasiat(Wasiat wasiat);

    // Wasiat getWasiatDetailsByUserId(Long userId);

    User getWasiatDetailsByUserId(Long userId);
    
}
