package com.zavadka.lab5.lab5.service;

import com.zavadka.lab5.lab5.domain.Response;

public interface ResponseService extends GeneralService<Response, Integer> {
    void insertResponses(String text_response);

}
