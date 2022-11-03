package com.zavadka.lab5.lab5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "appartment_adress", schema = "air_bnb", catalog = "")
public class AppartmentAdress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "house_number")
    private Integer houseNumber;
    @Basic
    @Column(name = "appartment_number")
    private Integer appartmentNumber;
    @ManyToOne
    @JoinColumn(name = "appartment_id", referencedColumnName = "id", nullable = false)
    private Appartment appartment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(Integer appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppartmentAdress that = (AppartmentAdress) o;
        return Objects.equals(id, that.id) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(appartmentNumber, that.appartmentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, houseNumber, appartmentNumber);
    }

    public Appartment getAppartmentId() {
        return appartment;
    }

    public void setAppartmentId(Appartment appartmentId) {
        this.appartment = appartmentId;
    }
}
