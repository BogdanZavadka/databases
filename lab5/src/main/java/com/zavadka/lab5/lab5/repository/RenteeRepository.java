package com.zavadka.lab5.lab5.repository;

import com.zavadka.lab5.lab5.domain.Rentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RenteeRepository extends JpaRepository<Rentee, Integer> {
    @Procedure
    Rentee insertIntoRentee(String name, String surname, String phone_number, String email, String gender,
                          String birthday, Integer rentee_balance_id);

    @Procedure
    void createTables();
}
