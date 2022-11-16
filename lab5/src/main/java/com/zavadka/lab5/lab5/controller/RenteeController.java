package com.zavadka.lab5.lab5.controller;

import com.zavadka.lab5.lab5.domain.Rentee;
import com.zavadka.lab5.lab5.dto.RenteeDto;
import com.zavadka.lab5.lab5.dto.assembler.RenteeDtoAssembler;
import com.zavadka.lab5.lab5.service.RenteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rentees")
public class RenteeController {
    @Autowired
    private RenteeService renteeService;
    @Autowired
    private RenteeDtoAssembler renteeDtoAssembler;

    @GetMapping(value = "/{renteeId}")
    public ResponseEntity<RenteeDto> getRentee(@PathVariable Integer renteeId) {
        Rentee rentee = renteeService.findById(renteeId);
        RenteeDto renteeDto = renteeDtoAssembler.toModel(rentee);
        return new ResponseEntity<>(renteeDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<RenteeDto>> getAllRentees() {
        List<Rentee> rentee = renteeService.findAll();
        CollectionModel<RenteeDto> renteeDtos = renteeDtoAssembler.toCollectionModel(rentee);
        return new ResponseEntity<>(renteeDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<RenteeDto> addRentee(@RequestBody Rentee rentee) {
        Rentee newRentee = renteeService.create(rentee);
        RenteeDto renteeDto = renteeDtoAssembler.toModel(newRentee);
        return new ResponseEntity<>(renteeDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{renteeId}")
    public ResponseEntity<?> updateRentee(@RequestBody Rentee uRentee, @PathVariable Integer renteeId) {
        renteeService.update(renteeId, uRentee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{renteeId}")
    public ResponseEntity<?> deleteRentee(@PathVariable Integer renteeId) {
        renteeService.delete(renteeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/post_with_procedure")
    public ResponseEntity<RenteeDto> addRenteeWithProcedure(@RequestBody Rentee rentee) {
        Rentee rentee1 = renteeService.createWithProcedure(rentee);
        RenteeDto renteeDto = renteeDtoAssembler.toModel(rentee1);
        return new ResponseEntity<>(renteeDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/create_tables")
    public ResponseEntity<?> createTables() {
        renteeService.createTables();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
