package com.zavadka.lab5.lab5.service.impl;

import com.zavadka.lab5.lab5.domain.RenteeBalance;
import com.zavadka.lab5.lab5.exception.RenteeBalanceNotFoundException;
import com.zavadka.lab5.lab5.repository.RenteeBalanceRepository;
import com.zavadka.lab5.lab5.service.RenteeBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenteeBalanceServiceImpl implements RenteeBalanceService {

    @Autowired
    private RenteeBalanceRepository renteeBalanceRepository;

    @Override
    public List<RenteeBalance> findAll() {
        return renteeBalanceRepository.findAll();
    }

    @Override
    public RenteeBalance findById(Integer id) {
        return renteeBalanceRepository.findById(id)
                .orElseThrow(() -> new RenteeBalanceNotFoundException(id));
    }

    @Override
    public RenteeBalance create(RenteeBalance entity) {
        return renteeBalanceRepository.save(entity);
    }

    @Override
    public void update(Integer id, RenteeBalance uRenteeBalance) {
        RenteeBalance renteeBalance = renteeBalanceRepository.findById(id)
                .orElseThrow(() -> new RenteeBalanceNotFoundException(id));
        renteeBalance.setCurrency(uRenteeBalance.getCurrency());
        renteeBalance.setMoney_amount(uRenteeBalance.getMoney_amount());
        renteeBalanceRepository.save(renteeBalance);
    }

    @Override
    public void delete(Integer id) {
        RenteeBalance renteeBalance = renteeBalanceRepository.findById(id)
                .orElseThrow(() -> new RenteeBalanceNotFoundException(id));
        renteeBalanceRepository.delete(renteeBalance);
    }
}
