package com.project.estatemanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AnakPerempuanDetail {

    @Column(name = "name")
    private String name;

    @Column(name = "ic")
    private String ic;

    @Column(name = "oku")
    private String oku;

    // Constructors, getters, setters...

}
