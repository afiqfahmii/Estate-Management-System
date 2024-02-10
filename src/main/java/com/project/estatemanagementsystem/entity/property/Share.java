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
@Table(name="share")
public class Share extends Property{

    private String agencyName;

    
    private String agencyAddress;

    
    private double amount;

    
    private double share;

}

