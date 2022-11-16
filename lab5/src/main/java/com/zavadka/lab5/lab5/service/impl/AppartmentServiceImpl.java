package com.zavadka.lab5.lab5.service.impl;

import com.zavadka.lab5.lab5.domain.Appartment;
import com.zavadka.lab5.lab5.domain.Renter;
import com.zavadka.lab5.lab5.exception.AppartmentNotFoundException;
import com.zavadka.lab5.lab5.exception.RenterNotFoundException;
import com.zavadka.lab5.lab5.repository.AppartmentRepository;
import com.zavadka.lab5.lab5.repository.RenterRepository;
import com.zavadka.lab5.lab5.service.AppartmentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppartmentServiceImpl implements AppartmentService {
    final
    AppartmentRepository appartmentRepository;

    final RenterRepository renterRepository;

    public AppartmentServiceImpl(AppartmentRepository appartmentRepository, RenterRepository renterRepository) {
        this.appartmentRepository = appartmentRepository;
        this.renterRepository = renterRepository;
    }

    @Override
    public List<Appartment> findAll() {
        return appartmentRepository.findAll();
    }

    @Override
    public Appartment findById(Integer id) {
        return appartmentRepository.findById(id).orElseThrow(() -> new AppartmentNotFoundException(id));
    }

    @Override
    @Transactional
    public Appartment create(Appartment appartment) {
        appartmentRepository.save(appartment);
        return appartment;
    }

    @Override
    @Transactional
    public void update(Integer id, Appartment uAppartment) {
        Appartment appartment = appartmentRepository.findById(id)
                .orElseThrow(() -> new AppartmentNotFoundException(id));
        appartment.setArea(uAppartment.getArea());
        appartment.setRoomNumber(uAppartment.getRoomNumber());
        appartment.setOverallRating(uAppartment.getOverallRating());
        appartment.setPricePerDay(uAppartment.getPricePerDay());
        appartment.setRenter(uAppartment.getRenter());
        appartmentRepository.save(appartment);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Appartment appartment = appartmentRepository.findById(id)
                .orElseThrow(() -> new AppartmentNotFoundException(id));
        appartmentRepository.delete(appartment);
    }

    @Override
    public List<Appartment> findAppartmentsByRenterId(Integer renterId) {
        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(() -> new RenterNotFoundException(renterId));
        return renter.getAppartments().stream().toList();
    }

    @Override
    public Float getAvarageAppartmentPrice(){
        return appartmentRepository.getAvarageAppartmentPrice();
    }
}
