package com.lab4.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Request {
    private Integer id;
    private String startDate;
    private String endDate;
    private Integer renteeId;
    private Integer appartmentId;
}
