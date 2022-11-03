package com.zavadka.lab5.lab5.dto.assembler;

import com.zavadka.lab5.lab5.controller.AppartmentAdressController;
import com.zavadka.lab5.lab5.domain.AppartmentAdress;
import com.zavadka.lab5.lab5.dto.AppartmentAdressDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AppartmentAdressDtoAssembler implements RepresentationModelAssembler<AppartmentAdress, AppartmentAdressDto> {
    @Override
    public AppartmentAdressDto toModel(AppartmentAdress entity) {
        AppartmentAdressDto appartmentAdressDto = AppartmentAdressDto.builder()
                .id(entity.getId())
                .country(entity.getCountry())
                .city(entity.getCity())
                .street(entity.getStreet())
                .house_number(entity.getHouseNumber())
                .appartment_number(entity.getAppartmentNumber())
                .build();
        Link selfLink = linkTo(methodOn(AppartmentAdressController.class).getAppartmentAdress(appartmentAdressDto.getId())).withSelfRel();
        appartmentAdressDto.add(selfLink);
        return appartmentAdressDto;
    }

    @Override
    public CollectionModel<AppartmentAdressDto> toCollectionModel(Iterable<? extends AppartmentAdress> entities) {
        CollectionModel<AppartmentAdressDto> bookDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AppartmentAdressController.class).getAllAppartmentAdresses()).withSelfRel();
        bookDtos.add(selfLink);
        return bookDtos;
    }

    public CollectionModel<AppartmentAdressDto> toCollectionModel(Iterable<? extends AppartmentAdress> entities, Link link) {
        CollectionModel<AppartmentAdressDto> appartmentAdressDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        appartmentAdressDtos.add(link);
        return appartmentAdressDtos;
    }
}
