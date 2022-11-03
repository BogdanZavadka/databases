package com.zavadka.lab5.lab5.dto.assembler;

import com.zavadka.lab5.lab5.controller.AppartmentController;
import com.zavadka.lab5.lab5.domain.Appartment;
import com.zavadka.lab5.lab5.dto.AppartmentDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AppartmentDtoAssembler implements RepresentationModelAssembler<Appartment, AppartmentDto> {
    @Override
    public AppartmentDto toModel(Appartment entity) {
        AppartmentDto appartmentDto = AppartmentDto.builder()
                .id(entity.getId())
                .area(entity.getArea())
                .room_number(entity.getRoomNumber())
                .overall_rating(entity.getOverallRating())
                .price_per_day(entity.getPricePerDay())
                .renter(entity.getRenter().getId())
                .build();
        Link selfLink = linkTo(methodOn(AppartmentController.class).getAppartment(appartmentDto.getId())).withSelfRel();
        appartmentDto.add(selfLink);
        return appartmentDto;
    }

    @Override
    public CollectionModel<AppartmentDto> toCollectionModel(Iterable<? extends Appartment> entities) {
        CollectionModel<AppartmentDto> appartmentDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AppartmentController.class).getAllAppartments()).withSelfRel();
        appartmentDtos.add(selfLink);
        return appartmentDtos;
    }

    public CollectionModel<AppartmentDto> toCollectionModel(Iterable<? extends Appartment> entities, Link link) {
        CollectionModel<AppartmentDto> appartmentDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        appartmentDtos.add(link);
        return appartmentDtos;
    }
}
