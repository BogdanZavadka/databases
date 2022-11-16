package com.lab4.controller.impl;

import com.lab4.controller.AppartmentController;
import com.lab4.domain.Appartment;
import com.lab4.service.AppartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartmentControllerImpl implements AppartmentController {
    private final AppartmentService appartmentService;

    public AppartmentControllerImpl(AppartmentService appartmentService) {
        this.appartmentService = appartmentService;
    }

    @Override
    public List<Appartment> findAll() {
        return appartmentService.findAll();
    }

    @Override
    public Optional<Appartment> findById(Integer id) {
        return appartmentService.findById(id);
    }

    @Override
    public int create(Appartment appartment) {
        return appartmentService.create(appartment);
    }

    @Override
    public int update(Integer id, Appartment appartment) {
        return appartmentService.update(id, appartment);
    }

    @Override
    public int delete(Integer id) {
        return appartmentService.delete(id);
    }

    @Override
    public Optional<List<Appartment>> getAppartmentsByRating(Integer rating) {
        return appartmentService.getAppartmentsByRating(rating);
    }
}
