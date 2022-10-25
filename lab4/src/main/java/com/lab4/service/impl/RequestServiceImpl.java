package com.lab4.service.impl;

import com.lab4.dao.RequestDao;
import com.lab4.domain.Request;
import com.lab4.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {
    private final RequestDao requestDao;

    public RequestServiceImpl(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public List<Request> findAll() {
        return requestDao.findAll();
    }

    @Override
    public Optional<Request> findById(Integer id) {
        return requestDao.findById(id);
    }

    @Override
    public int create(Request request) {
        return requestDao.create(request);
    }

    @Override
    public int update(Integer id, Request request) {
        return requestDao.update(id, request);
    }

    @Override
    public int delete(Integer id) {
        return requestDao.delete(id);
    }
}
