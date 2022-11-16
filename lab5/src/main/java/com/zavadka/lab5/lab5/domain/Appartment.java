package com.zavadka.lab5.lab5.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "appartment", schema = "air_bnb", catalog = "")
public class Appartment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "area")
    private Integer area;
    @Basic
    @Column(name = "room_number")
    private Integer roomNumber;
    @Basic
    @Column(name = "overall_rating")
    private Integer overallRating;
    @Basic
    @Column(name = "price_per_day")
    private Integer pricePerDay;
//    @Basic
//    @Column(name = "renter_id")
//    private Integer renterId;
    @ManyToOne
    @JoinColumn(name = "renter_id", referencedColumnName = "id", nullable = false)
    private Renter renter;
    @OneToMany(mappedBy = "appartment")
    private List<AppartmentAdress> appartmentAdresses;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appartment that = (Appartment) o;
        return Objects.equals(id, that.id) && Objects.equals(area, that.area) && Objects.equals(roomNumber, that.roomNumber) && Objects.equals(overallRating, that.overallRating) && Objects.equals(pricePerDay, that.pricePerDay);//  && Objects.equals(renterId, that.renterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, roomNumber, overallRating, pricePerDay);
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public List<AppartmentAdress> getAppartmentAdresses() {
        return appartmentAdresses;
    }

    public void setAppartmentAdresses(List<AppartmentAdress> appartmentAdresses) {
        this.appartmentAdresses = appartmentAdresses;
    }

}
