package com.lab4.dao;

import com.lab4.domain.Rentee;

import java.util.List;
import java.util.Optional;

public interface RenteeDao extends GeneralDao<Rentee, Integer> {
    Optional<List<Rentee>> getRenteesByGender(String gender);
}
