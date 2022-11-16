package com.zavadka.lab5.lab5.controller;

import com.zavadka.lab5.lab5.domain.Response;
import com.zavadka.lab5.lab5.dto.ResponseDto;
import com.zavadka.lab5.lab5.dto.assembler.ResponseDtoAssembler;
import com.zavadka.lab5.lab5.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/responses")
public class ResponseController {
    @Autowired
    private ResponseService responseService;
    @Autowired
    private ResponseDtoAssembler responseDtoAssembler;

    @GetMapping(value = "/{responseId}")
    public ResponseEntity<ResponseDto> getResponse(@PathVariable Integer responseId) {
        Response response = responseService.findById(responseId);
        ResponseDto responseDto = responseDtoAssembler.toModel(response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ResponseDto>> getAllResponses() {
        List<Response> response = responseService.findAll();
        CollectionModel<ResponseDto> responseDtos = responseDtoAssembler.toCollectionModel(response);
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ResponseDto> addResponse(@RequestBody Response response) {
        Response newResponse = responseService.create(response);
        ResponseDto responseDto = responseDtoAssembler.toModel(newResponse);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{responseId}")
    public ResponseEntity<?> updateResponse(@RequestBody Response uResponse, @PathVariable Integer responseId) {
        responseService.update(responseId, uResponse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{responseId}")
    public ResponseEntity<?> deleteResponse(@PathVariable Integer responseId) {
        responseService.delete(responseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/insert_10_responses/{responseText}")
    public ResponseEntity<?> insertTenResponses(@PathVariable String responseText){
        responseService.insertResponses(responseText);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
