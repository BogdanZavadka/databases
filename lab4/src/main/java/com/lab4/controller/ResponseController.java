package com.lab4.controller;

import com.lab4.domain.Response;

import java.util.List;
import java.util.Optional;

public interface ResponseController extends GeneralController<Response, Integer> {
    Optional<List<Response>> getResponsesByRating(Integer rating);
}
