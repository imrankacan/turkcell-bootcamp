package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers") //tablonun adı
@Entity
public class Customer {

    @Id
    @Column(name="customer_id")
    private String customerId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="contanct_name")
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
    private String faxn;

    @OneToMany(mappedBy = "customer")
    private List<Order>orders;




}
