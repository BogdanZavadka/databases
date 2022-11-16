package com.zavadka.lab5.lab5.exception;

public class AppartmentAdressNotFoundException extends RuntimeException{
    public AppartmentAdressNotFoundException(Integer  id){
        super("Could not find 'AppartmentAdress' with id=" + id);
    }
}
