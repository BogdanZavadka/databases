package com.zavadka.lab5.lab5.dto.assembler;

import com.zavadka.lab5.lab5.controller.RenteeController;
import com.zavadka.lab5.lab5.domain.Rentee;
import com.zavadka.lab5.lab5.dto.RenteeDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RenteeDtoAssembler implements RepresentationModelAssembler<Rentee, RenteeDto> {
    @Override
    public RenteeDto toModel(Rentee entity) {
        RenteeDto renteeDto = RenteeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phone_number(entity.getPhoneNumber())
                .email(entity.getEmail())
                .gender(entity.getGender())
                .birthday(entity.getBirthday())
                .rentee_balance_id(entity.getRentee_balance_id())
                .build();
        Link selfLink = linkTo(methodOn(RenteeController.class).getRentee(renteeDto.getId())).withSelfRel();
        renteeDto.add(selfLink);
        return renteeDto;
    }

    @Override
    public CollectionModel<RenteeDto> toCollectionModel(Iterable<? extends Rentee> entities) {
        CollectionModel<RenteeDto> renteeDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(RenteeController.class).getAllRentees()).withSelfRel();
        renteeDtos.add(selfLink);
        return renteeDtos;
    }

    public CollectionModel<RenteeDto> toCollectionModel(Iterable<? extends Rentee> entities, Link link) {
        CollectionModel<RenteeDto> renteeDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        renteeDtos.add(link);
        return renteeDtos;
    }
}
