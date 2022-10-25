package com.lab4.service;

import com.lab4.domain.Response;

import java.util.List;
import java.util.Optional;

public interface ResponseService extends GeneralService<Response, Integer> {
    Optional<List<Response>> getResponsesByRating(Integer rating);
}
