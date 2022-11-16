package com.zavadka.lab5.lab5.repository;

import com.zavadka.lab5.lab5.domain.RenteeBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenteeBalanceRepository extends JpaRepository<RenteeBalance, Integer> {
}
