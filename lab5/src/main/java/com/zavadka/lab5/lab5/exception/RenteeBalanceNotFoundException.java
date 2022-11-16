package com.zavadka.lab5.lab5.exception;

public class RenteeBalanceNotFoundException extends RuntimeException{
    public RenteeBalanceNotFoundException(Integer id){
        super("Could not find 'RenteeBalance' with id=" + id);
    }
}
