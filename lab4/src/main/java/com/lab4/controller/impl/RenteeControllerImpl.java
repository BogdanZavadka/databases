package com.lab4.controller.impl;

import com.lab4.controller.RenteeController;
import com.lab4.domain.Rentee;
import com.lab4.service.RenteeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenteeControllerImpl implements RenteeController {
    private final RenteeService renteeService;

    public RenteeControllerImpl(RenteeService renteeService) {
        this.renteeService = renteeService;
    }

    @Override
    public List<Rentee> findAll() {
        return renteeService.findAll();
    }

    @Override
    public Optional<Rentee> findById(Integer id) {
        return renteeService.findById(id);
    }

    @Override
    public int create(Rentee rentee) {
        return renteeService.create(rentee);
    }

    @Override
    public int update(Integer id, Rentee rentee) {
        return renteeService.update(id, rentee);
    }

    @Override
    public int delete(Integer id) {
        return renteeService.delete(id);
    }

    @Override
    public Optional<List<Rentee>> getRenteesByGender(String gender) {
        return renteeService.getRenteesByGender(gender);
    }
}
