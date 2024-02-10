package com.project.estatemanagementsystem.entity.property;

import java.sql.Date;

import com.project.estatemanagementsystem.entity.Property;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
//kenderaan
public class Vehicle extends Property{

    private String carRegNum;
    
    private String model;
    
    private String year;
    
    private Date transactionDate;

    private String brand;

    private int cc;

    private Date insuranceStartDate;
    
    private Date insuranceEndDate;
    
    private double insuranceAmount;

    private Date roadtaxStartDate;

    private Date roadtaxEndDate;

    private int roadtaxAmount;

}
