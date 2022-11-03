package com.lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppartmentAdress {
    private Integer id;
    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer appartmentNumber;
    private Integer appartmentId;
}
