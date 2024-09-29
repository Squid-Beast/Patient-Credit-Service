package com.example.patientspringproject.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDetails {
    private Long id;
    private String ssn;
    private int creditScore;
}
