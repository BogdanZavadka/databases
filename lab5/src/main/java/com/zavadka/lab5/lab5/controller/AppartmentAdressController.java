package com.zavadka.lab5.lab5.controller;

import com.zavadka.lab5.lab5.domain.AppartmentAdress;
import com.zavadka.lab5.lab5.dto.AppartmentAdressDto;
import com.zavadka.lab5.lab5.dto.assembler.AppartmentAdressDtoAssembler;
import com.zavadka.lab5.lab5.service.AppartmentAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/appartment_adresses")
public class AppartmentAdressController {
    @Autowired
    private AppartmentAdressService appartmentAdressService;
    @Autowired
    private AppartmentAdressDtoAssembler appartmentAdressDtoAssembler;

    @GetMapping(value = "/{appartmentAdressId}")
    public ResponseEntity<AppartmentAdressDto> getAppartmentAdress(@PathVariable Integer appartmentAdressId) {
        AppartmentAdress appartmentAdress = appartmentAdressService.findById(appartmentAdressId);
        AppartmentAdressDto appartmentAdressDto = appartmentAdressDtoAssembler.toModel(appartmentAdress);
        return new ResponseEntity<>(appartmentAdressDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<AppartmentAdressDto>> getAllAppartmentAdresses() {
        List<AppartmentAdress> appartmentAdresses = appartmentAdressService.findAll();
        CollectionModel<AppartmentAdressDto> appartmentAdressDtos = appartmentAdressDtoAssembler.toCollectionModel(appartmentAdresses);
        return new ResponseEntity<>(appartmentAdressDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AppartmentAdressDto> addAppartmentAdress(@RequestBody AppartmentAdress appartmentAdress) {
        AppartmentAdress newAppartmentAdress = appartmentAdressService.create(appartmentAdress);
        AppartmentAdressDto appartmentAdressDto = appartmentAdressDtoAssembler.toModel(newAppartmentAdress);
        return new ResponseEntity<>(appartmentAdressDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{appartmentAdressId}")
    public ResponseEntity<?> updateAppartmentAdress(@RequestBody AppartmentAdress uAppartmentAdress, @PathVariable Integer appartmentAdressId) {
        appartmentAdressService.update(appartmentAdressId, uAppartmentAdress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{appartmentAdressId}")
    public ResponseEntity<?> deleteAppartmentAdress(@PathVariable Integer appartmentAdressId) {
        appartmentAdressService.delete(appartmentAdressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
