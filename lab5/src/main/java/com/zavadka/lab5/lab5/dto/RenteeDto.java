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
@Relation(itemRelation = "rentee", collectionRelation = "rentees")
public class RenteeDto extends RepresentationModel<RenteeDto> {
    private Integer id;
    private String name;
    private String surname;
    private String phone_number;
    private String email;
    private String gender;
    private String birthday;
}
