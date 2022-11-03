package com.lab4.service;

import com.lab4.domain.Rentee;

import java.util.List;
import java.util.Optional;

public interface RenteeService extends GeneralService<Rentee, Integer> {
    Optional<List<Rentee>> getRenteesByGender(String gender);
}
