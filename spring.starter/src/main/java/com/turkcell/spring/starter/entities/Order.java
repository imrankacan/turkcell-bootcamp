package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data

@Table (name = "orders")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name="order_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Auto Implement
    private short orderId; //Smallint=> short

    /*@Column(name="customer_id")
    private String customerId;

    @Column(name="employee_id")
    private int employeeId;*/

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="required_date")
    private java.sql.Date requiredDate;

    @Column(name="shipped_date")
    private java.sql.Date shippedDate;

    //@Column(name="ship_via")
    //private int shipVia;

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

    //Foreign Key Alanları
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail>orderDetails;
}
