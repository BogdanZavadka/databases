package com.zavadka.lab5.lab5.service.impl;

import com.zavadka.lab5.lab5.domain.Rentee;
import com.zavadka.lab5.lab5.exception.RenteeNotFoundException;
import com.zavadka.lab5.lab5.repository.RenteeRepository;
import com.zavadka.lab5.lab5.service.RenteeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RenteeServiceImpl implements RenteeService {
    final
    RenteeRepository renteeRepository;

    public RenteeServiceImpl(RenteeRepository renteeRepository) {
        this.renteeRepository = renteeRepository;
    }

    @Override
    public List<Rentee> findAll() {
        return renteeRepository.findAll();
    }

    @Override
    public Rentee findById(Integer id) {
        return renteeRepository.findById(id).orElseThrow(() -> new RenteeNotFoundException(id));
    }

    @Override
    @Transactional
    public Rentee create(Rentee rentee) {
        renteeRepository.save(rentee);
        return rentee;
    }

    @Override
    @Transactional
    public Rentee createWithProcedure(Rentee rentee){
        return renteeRepository.insertIntoRentee(rentee.getName(), rentee.getSurname(), rentee.getPhoneNumber(), rentee.getEmail(),
                rentee.getGender(), rentee.getBirthday(), rentee.getRentee_balance_id());
    }

    @Override
    @Transactional
    public void update(Integer id, Rentee uRentee) {
        Rentee rentee = renteeRepository.findById(id)
                .orElseThrow(() -> new RenteeNotFoundException(id));
        rentee.setName(uRentee.getName());
        rentee.setSurname(uRentee.getSurname());
        rentee.setPhoneNumber(uRentee.getPhoneNumber());
        rentee.setEmail(uRentee.getEmail());
        rentee.setGender(uRentee.getGender());
        rentee.setBirthday(uRentee.getBirthday());
        rentee.setRentee_balance_id(uRentee.getRentee_balance_id());
        renteeRepository.save(rentee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Rentee rentee = renteeRepository.findById(id)
                .orElseThrow(() -> new RenteeNotFoundException(id));
        renteeRepository.delete(rentee);
    }

    @Override
    public void createTables() {
        renteeRepository.createTables();
    }
}
