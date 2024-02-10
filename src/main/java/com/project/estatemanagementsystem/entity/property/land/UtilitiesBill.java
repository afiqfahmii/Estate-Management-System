package com.project.estatemanagementsystem.entity.property.land;

import com.project.estatemanagementsystem.entity.Land;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilitiesbill")
public class UtilitiesBill extends Land{
    
    private String billNumber;

    
    private String accNumber;

    
    private double billOfMonth;

    
    private double amount;

    
    private double billOfYear; 
}
