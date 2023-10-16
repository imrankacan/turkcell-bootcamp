package com.turkcell.spring.starter.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table(name = "customer_customer_demo")
@Entity
public class CustomerDemo {
    @Id
    @Column(name="customer_id")
    private String customerId;

    @Column(name="customer_type_id")
    private String customerTypeId;
}
