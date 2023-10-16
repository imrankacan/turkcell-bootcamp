package com.turkcell.spring.starter.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table(name = "employees")
@Entity
public class Employee {

    @Id
    @Column(name="employee_id")
    private int employeeId;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="title")
    private String title;

    @Column(name="title_of_courtesy")
    private String titleOfCourtesy;

    @Column(name="birth_date")
    private java.sql.Date birthDate;

    @Column(name="hire_date")
    private java.sql.Date hireDate;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="region")
    private String region;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="country")
    private String country;

    @Column(name="home_phone")
    private String homePhone;

    @Column(name="extension")
    private String extension;

    @Column(name="photo")
    private byte[] photo; //bytea

    @Column(name="notes")
    private String notes;

    @Column(name="reports_to")
    private int reportsTo;

    @Column(name="photo_path")
    private String photo_path;
}
