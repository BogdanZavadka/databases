package com.zavadka.lab5.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "appartmentAdress", collectionRelation = "appartmentAdresses")
public class AppartmentAdressDto extends RepresentationModel<AppartmentAdressDto> {
    private Integer id;
    private String country;
    private String city;
    private String street;
    private Integer house_number;
    private Integer appartment_number;
    private Integer appartment;
}
