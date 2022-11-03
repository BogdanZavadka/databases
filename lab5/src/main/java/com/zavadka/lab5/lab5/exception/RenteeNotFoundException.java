package com.zavadka.lab5.lab5.exception;

public class RenteeNotFoundException extends RuntimeException {
    public RenteeNotFoundException(Integer id) {
        super("Could not find 'Rentee' with id=" + id);
    }
}
