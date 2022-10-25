package com.lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Appartment {
    private Integer id;
    private Integer area;
    private Integer roomNumber;
    private Integer overallRating;
    private Integer pricePerDay;
    private Integer renterId;
}
