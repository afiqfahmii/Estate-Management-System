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
@Table(name="unittrust")
//saham
public class UnitTrust extends Property{

    
    private int amount;

    
    private Date maturedDate;

}
