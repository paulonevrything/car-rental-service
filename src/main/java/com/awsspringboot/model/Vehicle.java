package com.awsspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Vehicle {

    @Id
    @Column(length = 50)
    private String Id;

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
