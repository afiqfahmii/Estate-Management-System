package com.project.estatemanagementsystem.dto;

import java.util.ArrayList;

import com.project.estatemanagementsystem.entity.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalWasiatDto {

    private Long id;
    private User user;

    @NotEmpty(message = "Content should not be empty")
    private ArrayList<String> isteriName;
    private ArrayList<String> anakLelakiName;
    private ArrayList<String> anakPerempuanName;
    private ArrayList<String> anakAngkatName;
    
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
