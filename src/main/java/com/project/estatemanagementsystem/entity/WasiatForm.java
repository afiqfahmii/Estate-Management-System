package com.project.estatemanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wasiat_form")
public class WasiatForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;
    private String isteri;
    private String suami;
    private String anakLelaki;
    private String anakPerempuan;
    private String anakAngkat;
    private String confirmation;
    private double perbelanjaan;
    private String anggaran;
    private String hibah;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getIsteri() {
        return isteri;
    }
    public void setIsteri(String isteri) {
        this.isteri = isteri;
    }
    public String getSuami() {
        return suami;
    }
    public void setSuami(String suami) {
        this.suami = suami;
    }
    public String getAnakLelaki() {
        return anakLelaki;
    }
    public void setAnakLelaki(String anakLelaki) {
        this.anakLelaki = anakLelaki;
    }
    public String getAnakPerempuan() {
        return anakPerempuan;
    }
    public void setAnakPerempuan(String anakPerempuan) {
        this.anakPerempuan = anakPerempuan;
    }
    public String getAnakAngkat() {
        return anakAngkat;
    }
    public void setAnakAngkat(String anakAngkat) {
        this.anakAngkat = anakAngkat;
    }
    public String getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
    public double getPerbelanjaan() {
        return perbelanjaan;
    }
    public void setPerbelanjaan(double perbelanjaan) {
        this.perbelanjaan = perbelanjaan;
    }
    public String getAnggaran() {
        return anggaran;
    }
    public void setAnggaran(String anggaran) {
        this.anggaran = anggaran;
    }
    public String getHibah() {
        return hibah;
    }
    public void setHibah(String hibah) {
        this.hibah = hibah;
    }
}
