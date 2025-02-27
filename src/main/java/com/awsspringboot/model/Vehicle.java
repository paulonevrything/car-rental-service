package com.awsspringboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

    @Id
    @Column(length = 50)
    private String Id;

    @Column(length = 50)
    private String model;

    @Column(length = 50)
    private String brand;

    @Column(length = 50)
    @JsonProperty("licence_number")
    private String licencePlateNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Status status;

    @Column(length = 30)
    private String owner;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 30)
    @JsonProperty("association_date")
    private Date associationDate;
}
