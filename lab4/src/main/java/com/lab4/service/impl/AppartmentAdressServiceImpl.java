package com.lab4.service.impl;

import com.lab4.dao.AppartmentAdressDao;
import com.lab4.domain.AppartmentAdress;
import com.lab4.service.AppartmentAdressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartmentAdressServiceImpl implements AppartmentAdressService {

    private final AppartmentAdressDao appartmentAdressDao;

    public AppartmentAdressServiceImpl(AppartmentAdressDao appartmentAdressDao) {
        this.appartmentAdressDao = appartmentAdressDao;
    }


    @Override
    public Optional<List<AppartmentAdress>> getAppartmentsByCountry(String country) {
        return appartmentAdressDao.getAppartmentsByCountry(country);
    }

    @Override
    public List<AppartmentAdress> findAll() {
        return appartmentAdressDao.findAll();
    }

    @Override
    public Optional<AppartmentAdress> findById(Integer id) {
        return appartmentAdressDao.findById(id);
    }

    @Override
    public int create(AppartmentAdress appartmentAdress) {
        return appartmentAdressDao.create(appartmentAdress);
    }

    @Override
    public int update(Integer id, AppartmentAdress appartmentAdress) {
        return appartmentAdressDao.update(id, appartmentAdress);
    }

    @Override
    public int delete(Integer id) {
        return appartmentAdressDao.delete(id);
    }
}
