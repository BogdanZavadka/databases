package com.zavadka.lab5.lab5.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "RenteeBalance", schema = "air_bnb", catalog = "")
public class RenteeBalance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "currency")
    private String currency;

    @Basic
    @Column(name = "money_amount")
    private Integer money_amount;
}
