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
public class AnakLelaki {
    @Column(name = "name")
    private String name;

    @Column(name = "id_number")
    private String idNumber;
}