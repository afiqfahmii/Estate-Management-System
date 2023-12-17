package com.project.estatemanagementsystem.entity;

import java.util.ArrayList;

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
@Table(name="additionalWasiat")
public class AdditionalWasiat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private ArrayList<String> isteriName;
    private ArrayList<String> anakLelakiName;
    private ArrayList<String> anakPerempuanName;
    private ArrayList<String> anakAngkatName;


    @ManyToOne
    @JoinColumn(name="USER_ID", referencedColumnName="ID")
    private User user;

    public void setIsteriName(ArrayList<String> isteriName){
        this.isteriName = isteriName;
    }
    public void setAnakLelakiName(ArrayList<String> anakLelakiName){
        this.anakLelakiName = anakLelakiName;
    }
    public void setAnakPerempuanName(ArrayList<String> anakPerempuanName){
        this.anakPerempuanName = anakPerempuanName;
    }
    public void setAnakAngkatName(ArrayList<String> anakAngkatName){
        this.anakAngkatName = anakAngkatName;
    }

    public ArrayList<String> getIsteriName(){
        return isteriName;
    }
    public ArrayList<String> getAnakLelakiName(){
        return anakLelakiName;
    }
    public ArrayList<String> getAnakPerempuanName(){
        return anakPerempuanName;
    }
    public ArrayList<String> getAnakAngkatName(){
        return anakAngkatName;
    }
}
