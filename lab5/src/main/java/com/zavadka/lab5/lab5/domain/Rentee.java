package com.zavadka.lab5.lab5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rentee", schema = "air_bnb", catalog = "")
public class Rentee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "birthday")
    private String birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rentee rentee = (Rentee) o;
        return Objects.equals(id, rentee.id) && Objects.equals(name, rentee.name) && Objects.equals(surname, rentee.surname) && Objects.equals(phoneNumber, rentee.phoneNumber) && Objects.equals(email, rentee.email) && Objects.equals(gender, rentee.gender) && Objects.equals(birthday, rentee.birthday) && Objects.equals(rentee_balance_id, rentee.rentee_balance_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, phoneNumber, email, gender, birthday, rentee_balance_id);
    }

    @Basic
    @Column(name = "rentee_balance_id")
    private Integer rentee_balance_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public Integer getRentee_balance_id() {
        return rentee_balance_id;
    }

    public void setRentee_balance_id(Integer rentee_balance_id) {
        this.rentee_balance_id = rentee_balance_id;
    }

}
