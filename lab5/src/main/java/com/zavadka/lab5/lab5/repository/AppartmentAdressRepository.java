package com.zavadka.lab5.lab5.repository;

import com.zavadka.lab5.lab5.domain.AppartmentAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppartmentAdressRepository extends JpaRepository<AppartmentAdress, Integer> {
}
