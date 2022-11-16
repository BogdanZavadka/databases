package com.zavadka.lab5.lab5.service;

import com.zavadka.lab5.lab5.domain.Appartment;

import java.util.List;

public interface AppartmentService extends GeneralService<Appartment, Integer> {
    List<Appartment> findAppartmentsByRenterId(Integer renterId);

    Float getAvarageAppartmentPrice();
}
