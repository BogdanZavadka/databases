package com.lab4.controller;

import com.lab4.domain.Rentee;

import java.util.List;
import java.util.Optional;

public interface RenteeController extends GeneralController<Rentee, Integer> {
    Optional<List<Rentee>> getRenteesByGender(String gender);
}
