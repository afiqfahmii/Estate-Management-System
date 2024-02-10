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
@Table(name = "charge")
public class Charge extends Land{

    
    private String chargorName;

    
    private String chargorIdNumber;

    
    private String chargeeName;

    
    private String chargeeIdNumber;

    
    private String chargeStatus;
    //charge, discharge  

    private double loanAmount;

    private String loanBankName;

    private String loanBankStatus;
    //active, frozen, closed

}
