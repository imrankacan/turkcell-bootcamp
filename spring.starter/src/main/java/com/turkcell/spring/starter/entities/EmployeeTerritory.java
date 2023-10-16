package com.turkcell.spring.starter.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table (name = "employee_territories")
@Entity
public class EmployeeTerritory {

    @Id
    @Column(name="employee_id")
    private int employeeId;

    @Column(name="territory_id")
    private String territoryId;
}
