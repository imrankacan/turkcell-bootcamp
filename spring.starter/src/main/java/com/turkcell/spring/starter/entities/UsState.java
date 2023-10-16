package com.turkcell.spring.starter.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table (name = "us_states")
@Entity
public class UsState {

    @Id
    @Column (name = "state_id")
    private int stateId;

    @Column(name="state_name")
    private String stateName;

    @Column(name="state_abbr")
    private String state_abbr;

    @Column(name="state_region")
    private String state_region;
}
