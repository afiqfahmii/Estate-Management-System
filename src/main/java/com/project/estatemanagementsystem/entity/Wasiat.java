package com.project.estatemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private String perbelanjaan;
    private String anggaran;
    private String hibah;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "anak_lelaki_detail", joinColumns = @JoinColumn(name = "wasiat_id"))
    private List<AnakLelakiDetail> anakLelakiDetails = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "anak_perempuan_detail", joinColumns = @JoinColumn(name = "wasiat_id"))
    private List<AnakPerempuanDetail> anakPerempuanDetails = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "anak_angkat_detail", joinColumns = @JoinColumn(name = "wasiat_id"))
    private List<AnakAngkatDetail> anakAngkatDetails = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "isteri_detail", joinColumns = @JoinColumn(name = "wasiat_id"))
    private List<IsteriDetail> isteriDetails = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "suami_detail", joinColumns = @JoinColumn(name = "wasiat_id"))
    private List<SuamiDetail> suamiDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="USER_ID", referencedColumnName="ID")
    private User user;
}
