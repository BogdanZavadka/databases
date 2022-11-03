package com.lab4.controller;

import com.lab4.domain.Appartment;

import java.util.List;
import java.util.Optional;

public interface AppartmentController extends GeneralController<Appartment, Integer> {
    Optional<List<Appartment>> getAppartmentsByRating(Integer rating);
}
