package com.turkcell.spring.starter.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table (name = "orders")
@Entity
public class Order {

    @Id
    @Column(name="order_id")
    private int orderId;

    @Column(name="customer_id")
    private String customerId;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="order_date")
    private java.sql.Date orderDate;

    @Column(name="required_date")
    private java.sql.Date requiredDate;

    @Column(name="shipped_date")
    private java.sql.Date shippedDate;

    @Column(name="ship_via")
    private int shipVia;

    @Column(name="freight")
    private float freight;

    @Column(name="ship_name")
    private String ship_name;

    @Column(name="ship_address")
    private String ship_address;

    @Column(name="ship_city")
    private String chipCity;

    @Column(name="ship_reqion")
    private String shipRegion;

    @Column(name="ship_postal_code")
    private String shipPortalCode;

    @Column(name="ship_country")
    private String shipCountry;
}
