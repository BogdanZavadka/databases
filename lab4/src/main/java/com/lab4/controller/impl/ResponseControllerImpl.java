package com.lab4.controller.impl;

import com.lab4.controller.ResponseController;
import com.lab4.domain.Response;
import com.lab4.service.ResponseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseControllerImpl implements ResponseController {
    private final ResponseService responseService;

    public ResponseControllerImpl(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public List<Response> findAll() {
        return responseService.findAll();
    }

    @Override
    public Optional<Response> findById(Integer id) {
        return responseService.findById(id);
    }

    @Override
    public int create(Response response) {
        return responseService.create(response);
    }

    @Override
    public int update(Integer id, Response response) {
        return responseService.update(id, response);
    }

    @Override
    public int delete(Integer id) {
        return responseService.delete(id);
    }

    @Override
    public Optional<List<Response>> getResponsesByRating(Integer rating) {
        return responseService.getResponsesByRating(rating);
    }
}
