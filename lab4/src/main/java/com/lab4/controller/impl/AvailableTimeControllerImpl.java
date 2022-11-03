package com.lab4.controller.impl;

import com.lab4.controller.AvailableTimeController;
import com.lab4.domain.AvailableTime;
import com.lab4.service.AvailableTimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailableTimeControllerImpl implements AvailableTimeController {
    private final AvailableTimeService availableTimeService;

    public AvailableTimeControllerImpl(AvailableTimeService availableTimeService) {
        this.availableTimeService = availableTimeService;
    }

    @Override
    public List<AvailableTime> findAll() {
        return availableTimeService.findAll();
    }

    @Override
    public Optional<AvailableTime> findById(Integer id) {
        return availableTimeService.findById(id);
    }

    @Override
    public int create(AvailableTime availableTime) {
        return availableTimeService.create(availableTime);
    }

    @Override
    public int update(Integer id, AvailableTime availableTime) {
        return availableTimeService.update(id, availableTime);
    }

    @Override
    public int delete(Integer id) {
        return availableTimeService.delete(id);
    }
}
