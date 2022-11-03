package com.lab4.service.impl;

import com.lab4.dao.RenteeDao;
import com.lab4.domain.Rentee;
import com.lab4.service.RenteeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenteeServiceImpl implements RenteeService {

    private final RenteeDao renteeDao;

    public RenteeServiceImpl(RenteeDao renteeDao) {
        this.renteeDao = renteeDao;
    }

    @Override
    public List<Rentee> findAll() {
        return renteeDao.findAll();
    }

    @Override
    public Optional<Rentee> findById(Integer id) {
        return renteeDao.findById(id);
    }

    @Override
    public int create(Rentee rentee) {
        return renteeDao.create(rentee);
    }

    @Override
    public int update(Integer id, Rentee rentee) {
        return renteeDao.update(id, rentee);
    }

    @Override
    public int delete(Integer id) {
        return renteeDao.delete(id);
    }

    @Override
    public Optional<List<Rentee>> getRenteesByGender(String gender) {
        return renteeDao.getRenteesByGender(gender);
    }
}
