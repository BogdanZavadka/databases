package com.lab4.service.impl;

import com.lab4.dao.AppartmentDao;
import com.lab4.domain.Appartment;
import com.lab4.service.AppartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartmentServiceImpl implements AppartmentService {

    private final AppartmentDao appartmentDao;

    public AppartmentServiceImpl(AppartmentDao appartmentDao) {
        this.appartmentDao = appartmentDao;
    }

    @Override
    public List<Appartment> findAll() {
        return appartmentDao.findAll();
    }

    @Override
    public Optional<Appartment> findById(Integer id) {
        return appartmentDao.findById(id);
    }

    @Override
    public int create(Appartment appartment) {
        return appartmentDao.create(appartment);
    }

    @Override
    public int update(Integer id, Appartment appartment) {
        return appartmentDao.update(id, appartment);
    }

    @Override
    public int delete(Integer id) {
        return appartmentDao.delete(id);
    }

    @Override
    public Optional<List<Appartment>> getAppartmentsByRating(Integer rating) {
        return appartmentDao.getAppartmentsByRating(rating);
    }
}
