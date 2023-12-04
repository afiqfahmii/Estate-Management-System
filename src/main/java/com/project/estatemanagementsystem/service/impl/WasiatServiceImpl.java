package com.project.estatemanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.estatemanagementsystem.dto.WasiatDto;
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
    public Wasiat saveWasiat(User user, String content) {
        Wasiat wasiat = new Wasiat();
        wasiat.setUser(user);
        wasiat.setContent(content);
        // You can set other properties like timestamp if needed
        return wasiatRepository.save(wasiat);
    }

    @Override
    public Wasiat findWasiatById(Long id) {
        return wasiatRepository.findById(id).orElse(null);
    }

@Override
@Transactional  // Ensure that the method is transactional
public void updateWasiat(Long id, String content) {
    try {
        Wasiat existingWasiat = wasiatRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Wasiat not found for update."));

        // Null check for content
        if (content != null) {
            existingWasiat.setContent(content);
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

//? Admin-------------------------------------------------------------------

  @Override
public List<WasiatDto> getAllWasiat() {
    List<Wasiat> wasiatList = wasiatRepository.findAll();
    return wasiatList.stream().map((wasiat) -> convertEntityToDto(wasiat))
            .collect(Collectors.toList());
}

private WasiatDto convertEntityToDto(Wasiat wasiat) {
    WasiatDto wasiatDto = new WasiatDto();
    wasiatDto.setUser(wasiat.getUser());
    wasiatDto.setContent(wasiat.getContent());
    // You can map other properties if needed
    return wasiatDto;
}

@Override
    public void deleteUserWasiat(Long userId) {
        wasiatRepository.deleteByUserId(userId);
    }


    //?edit
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
            updatedWasiat.setContent(wasiat.getContent()); // Update other fields as needed

            // Save the updated Wasiat
            wasiatRepository.save(updatedWasiat);
        } else {
            // Handle the case where the Wasiat with the given id is not found
            // You might want to throw an exception or handle it based on your requirements
            throw new EntityNotFoundException("Wasiat not found with id: " + wasiatId);
        }
    }
}