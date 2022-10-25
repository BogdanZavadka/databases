package com.lab4.dao;

import com.lab4.domain.AppartmentAdress;

import java.util.List;
import java.util.Optional;

public interface AppartmentAdressDao extends GeneralDao<AppartmentAdress, Integer> {
    Optional<List<AppartmentAdress>> getAppartmentsByCountry(String country);
}
