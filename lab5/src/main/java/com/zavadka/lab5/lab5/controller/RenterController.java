package com.zavadka.lab5.lab5.controller;

import com.zavadka.lab5.lab5.domain.Renter;
import com.zavadka.lab5.lab5.dto.RenterDto;
import com.zavadka.lab5.lab5.dto.assembler.RenterDtoAssembler;
import com.zavadka.lab5.lab5.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/renters")
public class RenterController {
    @Autowired
    private RenterService renterService;
    @Autowired
    private RenterDtoAssembler renterDtoAssembler;

    @GetMapping(value = "/{renterId}")
    public ResponseEntity<RenterDto> getRenter(@PathVariable Integer renterId) {
        Renter renter = renterService.findById(renterId);
        RenterDto renterDto = renterDtoAssembler.toModel(renter);
        return new ResponseEntity<>(renterDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<RenterDto>> getAllRenters() {
        List<Renter> renter = renterService.findAll();
        CollectionModel<RenterDto> renterDtos = renterDtoAssembler.toCollectionModel(renter);
        return new ResponseEntity<>(renterDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<RenterDto> addRenter(@RequestBody Renter renter) {
        Renter newRenter = renterService.create(renter);
        RenterDto renterDto = renterDtoAssembler.toModel(newRenter);
        return new ResponseEntity<>(renterDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{renterId}")
    public ResponseEntity<?> updateRenter(@RequestBody Renter uRenter, @PathVariable Integer renterId) {
        renterService.update(renterId, uRenter);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{renterId}")
    public ResponseEntity<?> deleteRenter(@PathVariable Integer renterId) {
        renterService.delete(renterId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
