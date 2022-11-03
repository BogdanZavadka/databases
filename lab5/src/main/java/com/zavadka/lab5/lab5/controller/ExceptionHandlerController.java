package com.zavadka.lab5.lab5.controller;

import com.zavadka.lab5.lab5.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(AppartmentAdressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String AppartmentAdressNotFoundHandler(AppartmentAdressNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AppartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String AppartmentNotFoundHandler(AppartmentNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(RenteeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String RenteeNotFoundHandler(RenteeNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(RenterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String RenterNotFoundHandler(RenterNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ResponseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ResponseNotFoundHandler(ResponseNotFoundException ex) {
        return ex.getMessage();
    }
}
