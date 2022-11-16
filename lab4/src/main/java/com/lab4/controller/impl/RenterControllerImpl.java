package com.lab4.controller.impl;

import com.lab4.controller.RenterController;
import com.lab4.domain.Renter;
import com.lab4.service.RenterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterControllerImpl implements RenterController {
    private final RenterService renterService;

    public RenterControllerImpl(RenterService renterService) {
        this.renterService = renterService;
    }

    @Override
    public List<Renter> findAll() {
        return renterService.findAll();
    }

    @Override
    public Optional<Renter> findById(Integer id) {
        return renterService.findById(id);
    }

    @Override
    public int create(Renter renter) {
        return renterService.create(renter);
    }

    @Override
    public int update(Integer id, Renter renter) {
        return renterService.update(id, renter);
    }

    @Override
    public int delete(Integer id) {
        return renterService.delete(id);
    }
}
