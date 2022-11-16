package com.zavadka.lab5.lab5.dto.assembler;

import com.zavadka.lab5.lab5.controller.AppartmentController;
import com.zavadka.lab5.lab5.controller.RenteeBalanceController;
import com.zavadka.lab5.lab5.domain.RenteeBalance;
import com.zavadka.lab5.lab5.dto.RenteeBalanceDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RenteeBalanceDtoAssembler implements RepresentationModelAssembler<RenteeBalance, RenteeBalanceDto> {
    @Override
    public RenteeBalanceDto toModel(RenteeBalance entity) {
        RenteeBalanceDto renteeBalanceDto = RenteeBalanceDto.builder()
                .id(entity.getId())
                .currency(entity.getCurrency())
                .money_amount(entity.getMoney_amount())
                .build();
        Link selfLink = linkTo(methodOn(AppartmentController.class).getAppartment(renteeBalanceDto.getId())).withSelfRel();
        renteeBalanceDto.add(selfLink);
        return renteeBalanceDto;
    }

    @Override
    public CollectionModel<RenteeBalanceDto> toCollectionModel(Iterable<? extends RenteeBalance> entities) {
        CollectionModel<RenteeBalanceDto> renteeBalanceDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(RenteeBalanceController.class).getAllRenteeBalances()).withSelfRel();
        renteeBalanceDtos.add(selfLink);
        return renteeBalanceDtos;
    }
}
