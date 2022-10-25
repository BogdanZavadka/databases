package com.lab4.service;

import com.lab4.domain.AppartmentAdress;

import java.util.List;
import java.util.Optional;

public interface AppartmentAdressService extends GeneralService<AppartmentAdress, Integer> {
    Optional<List<AppartmentAdress>> getAppartmentsByCountry(String country);
}
