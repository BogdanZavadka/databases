package com.zavadka.lab5.lab5.repository;

import com.zavadka.lab5.lab5.domain.Appartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartmentRepository extends JpaRepository<Appartment, Integer> {
    List<Appartment> findAppartmentsByRenterId(Integer id);

    @Procedure
    Float getAvarageAppartmentPrice();
}
