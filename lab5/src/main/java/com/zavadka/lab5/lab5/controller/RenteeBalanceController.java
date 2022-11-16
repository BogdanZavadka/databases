package com.zavadka.lab5.lab5.controller;

import com.zavadka.lab5.lab5.domain.Appartment;
import com.zavadka.lab5.lab5.domain.RenteeBalance;
import com.zavadka.lab5.lab5.dto.AppartmentDto;
import com.zavadka.lab5.lab5.dto.RenteeBalanceDto;
import com.zavadka.lab5.lab5.dto.assembler.AppartmentDtoAssembler;
import com.zavadka.lab5.lab5.dto.assembler.RenteeBalanceDtoAssembler;
import com.zavadka.lab5.lab5.service.AppartmentService;
import com.zavadka.lab5.lab5.service.RenteeBalanceService;
import com.zavadka.lab5.lab5.service.RenteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rentee_balance")
public class RenteeBalanceController {
    @Autowired
    private RenteeBalanceService renteeBalanceService;

    @Autowired
    private RenteeBalanceDtoAssembler renteeBalanceDtoAssembler;

    @GetMapping(value = "/{renteeBalanceId}")
    public ResponseEntity<RenteeBalanceDto> getRenteeBalance(@PathVariable Integer renteeBalanceId) {
        RenteeBalance renteeBalance = renteeBalanceService.findById(renteeBalanceId);
        RenteeBalanceDto renteeBalanceDto = renteeBalanceDtoAssembler.toModel(renteeBalance);
        return new ResponseEntity<>(renteeBalanceDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<RenteeBalanceDto>> getAllRenteeBalances() {
        List<RenteeBalance> renteeBalances = renteeBalanceService.findAll();
        CollectionModel<RenteeBalanceDto> renteeBalanceDtos = renteeBalanceDtoAssembler.toCollectionModel(renteeBalances);
        return new ResponseEntity<>(renteeBalanceDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<RenteeBalanceDto> addRenteeBalance(@RequestBody RenteeBalance renteeBalance) {
        RenteeBalance uRenteeBalance = renteeBalanceService.create(renteeBalance);
        RenteeBalanceDto renteeBalanceDto = renteeBalanceDtoAssembler.toModel(uRenteeBalance);
        return new ResponseEntity<>(renteeBalanceDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{renteeBalanceId}")
    public ResponseEntity<?> updateRenteeBalance(@RequestBody RenteeBalance renteeBalance, @PathVariable Integer renteeBalanceId) {
        renteeBalanceService.update(renteeBalanceId, renteeBalance);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{renteeBalanceId}")
    public ResponseEntity<?> deleteRenteeBalance(@PathVariable Integer renteeBalanceId) {
        renteeBalanceService.delete(renteeBalanceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
