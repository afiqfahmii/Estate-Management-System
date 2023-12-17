package com.project.estatemanagementsystem.Exception;

public class WasiatNotFoundException extends RuntimeException{
    public WasiatNotFoundException(Long id){
        super("Could not found the user with id " + id);
    }
}
