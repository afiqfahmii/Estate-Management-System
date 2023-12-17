package com.project.estatemanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="wasiat")
public class Wasiat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String gender;

    private String isteri;
    private String suami;
    private String anakLelaki;
    private String anakPerempuan;
    private String anakAngkat;
    private String confirmation;
    private String perbelanjaan;
    private String anggaran;
    private String hibah;

    @ManyToOne
    @JoinColumn(name="USER_ID", referencedColumnName="ID")
    private User user;
}
