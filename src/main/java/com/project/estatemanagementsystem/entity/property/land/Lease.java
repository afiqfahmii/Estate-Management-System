package com.project.estatemanagementsystem.entity.property.land;

import java.sql.Date;

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
@Table(name = "lease")
public class Lease extends Land{

    private String lesserName;

    private String lesserIdNumber;

    private Date startDate;

    private Date endDate;

}
