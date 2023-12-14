package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data

@Table (name = "suppliers")
@Entity
@Builder
public class Supplier {

    @Id
    @Column(name="supplier_id")
    private short supplierId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="contact_title")
    private String contactTitle;

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

    @Column(name="phone")
    private String phone;

    @Column(name="fax")
    private String fax;

    @Column(name="homepage")
    private float homepage;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

}
