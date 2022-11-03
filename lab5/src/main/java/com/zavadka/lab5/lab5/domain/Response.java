package com.zavadka.lab5.lab5.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "response", schema = "air_bnb", catalog = "")
public class Response {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "photo_href")
    private String photoHref;
    @Basic
    @Column(name = "text_response")
    private String textResponse;
    @Basic
    @Column(name = "rating")
    private Integer rating;
    @ManyToMany(mappedBy = "responses")
    private Set<Appartment> appartments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoHref() {
        return photoHref;
    }

    public void setPhotoHref(String photoHref) {
        this.photoHref = photoHref;
    }

    public String getTextResponse() {
        return textResponse;
    }

    public void setTextResponse(String textResponse) {
        this.textResponse = textResponse;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response that = (Response) o;
        return Objects.equals(id, that.id) && Objects.equals(photoHref, that.photoHref) && Objects.equals(textResponse, that.textResponse) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, photoHref, textResponse, rating);
    }

    public Set<Appartment> getAppartments() {
        return appartments;
    }

    public void setAppartments(Set<Appartment> appartments) {
        this.appartments = appartments;
    }
}
