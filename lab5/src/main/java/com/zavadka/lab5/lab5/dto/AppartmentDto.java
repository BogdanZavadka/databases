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
@Relation(itemRelation = "appartment", collectionRelation = "appartments")
public class AppartmentDto extends RepresentationModel<AppartmentDto> {
    private Integer id;
    private Integer area;
    private Integer room_number;
    private Integer overall_rating;
    private Integer price_per_day;
    private Integer renter;
}
