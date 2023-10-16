package com.turkcell.spring.starter.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table (name = "territories")
@Entity
public class Territory {

    @Id
    @Column(name="territory_id")
    private String territoryId;

    @Column(name="territory_description")
    private char territoryDescription;

    @Column(name="region_id")
    private int regionId;
}
