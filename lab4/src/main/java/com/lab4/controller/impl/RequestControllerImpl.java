package com.lab4.controller.impl;

import com.lab4.controller.RequestController;
import com.lab4.domain.Request;
import com.lab4.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestControllerImpl implements RequestController {
    private final RequestService requestService;

    public RequestControllerImpl(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public List<Request> findAll() {
        return requestService.findAll();
    }

    @Override
    public Optional<Request> findById(Integer id) {
        return requestService.findById(id);
    }

    @Override
    public int create(Request request) {
        return requestService.create(request);
    }

    @Override
    public int update(Integer id, Request request) {
        return requestService.update(id, request);
    }

    @Override
    public int delete(Integer id) {
        return requestService.delete(id);
    }
}
