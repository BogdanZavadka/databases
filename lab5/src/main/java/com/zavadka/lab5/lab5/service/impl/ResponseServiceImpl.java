package com.zavadka.lab5.lab5.service.impl;

import com.zavadka.lab5.lab5.domain.Response;
import com.zavadka.lab5.lab5.exception.ResponseNotFoundException;
import com.zavadka.lab5.lab5.repository.ResponseRepository;
import com.zavadka.lab5.lab5.service.ResponseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    final
    ResponseRepository responseRepository;

    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }

    @Override
    public Response findById(Integer id) {
        return responseRepository.findById(id).orElseThrow(() -> new ResponseNotFoundException(id));
    }

    @Override
    @Transactional
    public Response create(Response response) {
        responseRepository.save(response);
        return response;
    }

    @Override
    @Transactional
    public void update(Integer id, Response uResponse) {
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new ResponseNotFoundException(id));
        response.setPhotoHref(uResponse.getPhotoHref());
        response.setTextResponse(uResponse.getTextResponse());
        response.setRating(uResponse.getRating());
        responseRepository.save(response);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new ResponseNotFoundException(id));
        responseRepository.delete(response);
    }

    @Override
    @Transactional
    public void insertResponses(String text_response){
        responseRepository.insertResponses(text_response);
    }

}
