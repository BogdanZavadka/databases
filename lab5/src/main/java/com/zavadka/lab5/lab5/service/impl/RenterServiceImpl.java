package com.zavadka.lab5.lab5.service.impl;

import com.zavadka.lab5.lab5.domain.Renter;
import com.zavadka.lab5.lab5.exception.RenterNotFoundException;
import com.zavadka.lab5.lab5.repository.RenterRepository;
import com.zavadka.lab5.lab5.service.RenterService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RenterServiceImpl implements RenterService {
    final
    RenterRepository renterRepository;

    public RenterServiceImpl(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Override
    public List<Renter> findAll() {
        return renterRepository.findAll();
    }

    @Override
    public Renter findById(Integer id) {
        return renterRepository.findById(id).orElseThrow(() -> new RenterNotFoundException(id));
    }

    @Override
    @Transactional
    public Renter create(Renter renter) {
        renterRepository.save(renter);
        return renter;
    }

    @Override
    @Transactional
    public void update(Integer id, Renter uRenter) {
        Renter renter = renterRepository.findById(id)
                .orElseThrow(() -> new RenterNotFoundException(id));
        renter.setName(uRenter.getName());
        renter.setSurname(uRenter.getSurname());
        renter.setPhoneNumber(uRenter.getPhoneNumber());
        renter.setEmail(uRenter.getEmail());
        renterRepository.save(renter);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Renter renter = renterRepository.findById(id)
                .orElseThrow(() -> new RenterNotFoundException(id));
        renterRepository.delete(renter);
    }
}
