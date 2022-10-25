package com.lab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private Integer id;
    private String photoHref;
    private String textResponse;
    private Integer rating;
}
