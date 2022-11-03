package com.lab4.service;

import com.lab4.domain.Appartment;

import java.util.List;
import java.util.Optional;

public interface AppartmentService extends GeneralService<Appartment, Integer> {
    Optional<List<Appartment>> getAppartmentsByRating(Integer rating);
}
