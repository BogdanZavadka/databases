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
@Relation(itemRelation = "rentee_balance", collectionRelation = "rentee_balances")
public class RenteeBalanceDto extends RepresentationModel<RenteeBalanceDto> {
    private Integer id;
    private String currency;
    private Integer money_amount;
}
