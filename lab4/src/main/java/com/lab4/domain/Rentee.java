package com.lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Rentee {
    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String gender;
    private String birthday;
}
