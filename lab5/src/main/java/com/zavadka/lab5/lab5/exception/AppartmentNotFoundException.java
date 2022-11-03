package com.zavadka.lab5.lab5.exception;

public class AppartmentNotFoundException extends RuntimeException {
    public AppartmentNotFoundException(Integer id) {
        super("Could not find 'Appartment' with id=" + id);
    }
}
