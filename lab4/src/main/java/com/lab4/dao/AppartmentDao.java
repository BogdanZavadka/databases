package com.lab4.dao;

import com.lab4.domain.Appartment;

import java.util.List;
import java.util.Optional;

public interface AppartmentDao extends GeneralDao<Appartment, Integer> {
    Optional<List<Appartment>> getAppartmentsByRating(Integer rating);
}
