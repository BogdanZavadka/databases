package com.lab4.dao;

import com.lab4.domain.Response;

import java.util.List;
import java.util.Optional;

public interface ResponseDao extends GeneralDao<Response, Integer> {
    Optional<List<Response>> getResponsesByRating(Integer rating);
}
