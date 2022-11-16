package com.lab4.controller;

import com.lab4.domain.AppartmentAdress;

import java.util.List;
import java.util.Optional;

public interface AppartmentAdressController extends GeneralController<AppartmentAdress, Integer> {
    Optional<List<AppartmentAdress>> getAppartmentsByCountry(String country);
}
