package com.zavadka.lab5.lab5.repository;

import com.zavadka.lab5.lab5.domain.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
    @Procedure
    void insertResponses(String text_response);
}
