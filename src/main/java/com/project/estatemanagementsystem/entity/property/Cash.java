package com.project.estatemanagementsystem.entity.property;

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
@Table(name="cash")
//wang
public class Cash extends Property{

    private String accType;
    
    private String bankName;
    
    private String accNumber;
    
    private double amount;
    
    private String accStatus;

}
