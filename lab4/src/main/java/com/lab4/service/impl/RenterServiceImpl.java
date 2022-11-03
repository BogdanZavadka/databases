package com.lab4.service.impl;

import com.lab4.dao.RenterDao;
import com.lab4.domain.Renter;
import com.lab4.service.RenterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterServiceImpl implements RenterService {
    private final RenterDao renterDao;

    public RenterServiceImpl(RenterDao renterDao) {
        this.renterDao = renterDao;
    }

    @Override
    public List<Renter> findAll() {
        return renterDao.findAll();
    }

    @Override
    public Optional<Renter> findById(Integer id) {
        return renterDao.findById(id);
    }

    @Override
    public int create(Renter renter) {
        return renterDao.create(renter);
    }

    @Override
    public int update(Integer id, Renter renter) {
        return renterDao.update(id, renter);
    }

    @Override
    public int delete(Integer id) {
        return renterDao.delete(id);
    }
}
