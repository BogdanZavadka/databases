package com.zavadka.lab5.lab5.controller;

import com.zavadka.lab5.lab5.domain.Appartment;
import com.zavadka.lab5.lab5.dto.AppartmentDto;
import com.zavadka.lab5.lab5.dto.assembler.AppartmentDtoAssembler;
import com.zavadka.lab5.lab5.service.AppartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/appartments")
public class AppartmentController {
    @Autowired
    private AppartmentService appartmentService;
    @Autowired
    private AppartmentDtoAssembler appartmentDtoAssembler;

    @GetMapping(value = "/{appartmentId}")
    public ResponseEntity<AppartmentDto> getAppartment(@PathVariable Integer appartmentId) {
        Appartment appartment = appartmentService.findById(appartmentId);
        AppartmentDto appartmentDto = appartmentDtoAssembler.toModel(appartment);
        return new ResponseEntity<>(appartmentDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<AppartmentDto>> getAllAppartments() {
        List<Appartment> appartment = appartmentService.findAll();
        CollectionModel<AppartmentDto> appartmentDtos = appartmentDtoAssembler.toCollectionModel(appartment);
        return new ResponseEntity<>(appartmentDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AppartmentDto> addAppartment(@RequestBody Appartment appartment) {
        Appartment newAppartment = appartmentService.create(appartment);
        AppartmentDto appartmentDto = appartmentDtoAssembler.toModel(newAppartment);
        return new ResponseEntity<>(appartmentDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{appartmentId}")
    public ResponseEntity<?> updateAppartmentAdress(@RequestBody Appartment uAppartment, @PathVariable Integer appartmentId) {
        appartmentService.update(appartmentId, uAppartment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{appartmentId}")
    public ResponseEntity<?> deleteAppartment(@PathVariable Integer appartmentId) {
        appartmentService.delete(appartmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/rent/{renterId}")
    public ResponseEntity<CollectionModel<AppartmentDto>> getAllAppartmentsByRenterId(@PathVariable Integer renterId) {
        List<Appartment> appartments = appartmentService.findAppartmentsByRenterId(renterId);
        Link selfLink = linkTo(methodOn(AppartmentController.class).getAllAppartmentsByRenterId(renterId)).withSelfRel();
        CollectionModel<AppartmentDto> appartmentDtos = appartmentDtoAssembler.toCollectionModel(appartments, selfLink);
        return new ResponseEntity<>(appartmentDtos, HttpStatus.OK);
    }
}
