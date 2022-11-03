package com.zavadka.lab5.lab5.service.impl;

import com.zavadka.lab5.lab5.domain.AppartmentAdress;
import com.zavadka.lab5.lab5.exception.AppartmentAdressNotFoundException;
import com.zavadka.lab5.lab5.repository.AppartmentAdressRepository;
import com.zavadka.lab5.lab5.service.AppartmentAdressService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppartmentAdressServiceImpl implements AppartmentAdressService {

    final
    AppartmentAdressRepository appartmentAdressRepository;

    public AppartmentAdressServiceImpl(AppartmentAdressRepository appartmentAdressRepository) {
        this.appartmentAdressRepository = appartmentAdressRepository;
    }

    @Override
    public List<AppartmentAdress> findAll() {
        return appartmentAdressRepository.findAll();
    }

    @Override
    public AppartmentAdress findById(Integer id) {
        return appartmentAdressRepository.findById(id).orElseThrow(() -> new AppartmentAdressNotFoundException(id));
    }

    @Override
    @Transactional
    public AppartmentAdress create(AppartmentAdress appartmentAdress) {
        appartmentAdressRepository.save(appartmentAdress);
        return appartmentAdress;
    }

    @Override
    @Transactional
    public void update(Integer id, AppartmentAdress uAppartmentAdress) {
        AppartmentAdress appartmentAdress = appartmentAdressRepository.findById(id)
                .orElseThrow(() -> new AppartmentAdressNotFoundException(id));
        appartmentAdress.setCountry(uAppartmentAdress.getCountry());
        appartmentAdress.setCity(uAppartmentAdress.getCity());
        appartmentAdress.setStreet(uAppartmentAdress.getStreet());
        appartmentAdress.setAppartmentNumber(uAppartmentAdress.getAppartmentNumber());
//        appartmentAdress.setAppartmentId(uAppartmentAdress.getAppartmentId());
        appartmentAdressRepository.save(appartmentAdress);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        AppartmentAdress appartmentAdress = appartmentAdressRepository.findById(id)
                .orElseThrow(() -> new AppartmentAdressNotFoundException(id));
        appartmentAdressRepository.delete(appartmentAdress);
    }
}
