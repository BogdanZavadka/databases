package com.zavadka.lab5.lab5.exception;

public class RenterNotFoundException extends RuntimeException{
    public RenterNotFoundException(Integer id) {super("Could not find 'Renter' with id=" + id);}
}
