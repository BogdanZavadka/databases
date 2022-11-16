package com.lab4.service.impl;

import com.lab4.dao.ResponseDao;
import com.lab4.domain.Response;
import com.lab4.service.ResponseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {
    private final ResponseDao responseDao;

    public ResponseServiceImpl(ResponseDao responseDao) {
        this.responseDao = responseDao;
    }

    @Override
    public List<Response> findAll() {
        return responseDao.findAll();
    }

    @Override
    public Optional<Response> findById(Integer id) {
        return responseDao.findById(id);
    }

    @Override
    public int create(Response response) {
        return responseDao.create(response);
    }

    @Override
    public int update(Integer id, Response response) {
        return responseDao.update(id, response);
    }

    @Override
    public int delete(Integer id) {
        return responseDao.delete(id);
    }

    @Override
    public Optional<List<Response>> getResponsesByRating(Integer rating) {
        return responseDao.getResponsesByRating(rating);
    }
}
