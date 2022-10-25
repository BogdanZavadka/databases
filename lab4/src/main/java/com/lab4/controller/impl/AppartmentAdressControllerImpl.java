package com.lab4.controller.impl;

import com.lab4.controller.AppartmentAdressController;
import com.lab4.domain.AppartmentAdress;
import com.lab4.service.AppartmentAdressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartmentAdressControllerImpl implements AppartmentAdressController {
    private final AppartmentAdressService appartmentAdressService;

    public AppartmentAdressControllerImpl(AppartmentAdressService appartmentAdressService) {
        this.appartmentAdressService = appartmentAdressService;
    }

    @Override
    public Optional<List<AppartmentAdress>> getAppartmentsByCountry(String country) {
        return appartmentAdressService.getAppartmentsByCountry(country);
    }

    @Override
    public List<AppartmentAdress> findAll() {
        return appartmentAdressService.findAll();
    }

    @Override
    public Optional<AppartmentAdress> findById(Integer id) {
        return appartmentAdressService.findById(id);
    }

    @Override
    public int create(AppartmentAdress appartmentAdress) {
        return appartmentAdressService.create(appartmentAdress);
    }

    @Override
    public int update(Integer id, AppartmentAdress appartmentAdress) {
        return appartmentAdressService.update(id, appartmentAdress);
    }

    @Override
    public int delete(Integer id) {
        return appartmentAdressService.delete(id);
    }
}
