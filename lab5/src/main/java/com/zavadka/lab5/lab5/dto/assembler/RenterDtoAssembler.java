package com.zavadka.lab5.lab5.dto.assembler;

import com.zavadka.lab5.lab5.controller.RenterController;
import com.zavadka.lab5.lab5.domain.Renter;
import com.zavadka.lab5.lab5.dto.RenterDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Component
public class RenterDtoAssembler implements RepresentationModelAssembler<Renter, RenterDto> {
    @Override
    public RenterDto toModel(Renter entity) {
        RenterDto renterDto = RenterDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phone_number(entity.getPhoneNumber())
                .email(entity.getEmail())
                .build();
        Link selfLink = linkTo(methodOn(RenterController.class).getRenter(renterDto.getId())).withSelfRel();
        renterDto.add(selfLink);
        return renterDto;
    }

    @Override
    public CollectionModel<RenterDto> toCollectionModel(Iterable<? extends Renter> entities) {
        CollectionModel<RenterDto> renterDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(RenterController.class).getAllRenters()).withSelfRel();
        renterDtos.add(selfLink);
        return renterDtos;
    }

    public CollectionModel<RenterDto> toCollectionModel(Iterable<? extends Renter> entities, Link link) {
        CollectionModel<RenterDto> renterDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        renterDtos.add(link);
        return renterDtos;
    }
}
