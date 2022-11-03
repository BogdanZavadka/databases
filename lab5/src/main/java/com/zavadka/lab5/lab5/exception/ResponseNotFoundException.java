package com.zavadka.lab5.lab5.exception;

public class ResponseNotFoundException extends RuntimeException{
    public ResponseNotFoundException(Integer id) {super("Could not find 'Response' with id=" + id);}
}
