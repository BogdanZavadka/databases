package com.lab4.service.impl;

import com.lab4.dao.AvailableTimeDao;
import com.lab4.domain.AvailableTime;
import com.lab4.service.AvailableTimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailableTimeServiceImpl implements AvailableTimeService {

    private final AvailableTimeDao availableTimeDao;

    public AvailableTimeServiceImpl(AvailableTimeDao availableTimeDao) {
        this.availableTimeDao = availableTimeDao;
    }

    @Override
    public List<AvailableTime> findAll() {
        return availableTimeDao.findAll();
    }

    @Override
    public Optional<AvailableTime> findById(Integer id) {
        return availableTimeDao.findById(id);
    }

    @Override
    public int create(AvailableTime availableTime) {
        return availableTimeDao.create(availableTime);
    }

    @Override
    public int update(Integer id, AvailableTime availableTime) {
        return availableTimeDao.update(id, availableTime);
    }

    @Override
    public int delete(Integer id) {
        return availableTimeDao.delete(id);
    }
}
