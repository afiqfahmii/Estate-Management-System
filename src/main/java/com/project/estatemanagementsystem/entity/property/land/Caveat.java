package com.project.estatemanagementsystem.entity.property.land;

import com.project.estatemanagementsystem.entity.Property;

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
@Table(name = "caveat")
public class Caveat extends Property{

    private String titleId;
    
    private String caveatorName;

    private String caveatorIdNumber;

    private String caveatorAddress; 

}
