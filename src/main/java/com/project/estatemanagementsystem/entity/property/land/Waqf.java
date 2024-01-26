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
@Table(name = "waqf")
public class Waqf extends Property{

    private String titleId;

    
    private String nazirName;

    
    private String nazirIdNumber;

    
    private String status;
    //registered, notregistered

}
