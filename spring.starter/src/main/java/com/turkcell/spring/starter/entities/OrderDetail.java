package com.turkcell.spring.starter.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Table (name = "order_details")
@Entity
public class OrderDetail {

    @Id
    @Column(name="order_id")
    private int orderId;

    @Id
    @Column(name="product_id")
    private int productId;

    @Column(name="unit_price")
    private float unitPrice;

    @Column(name="quantitiy")
    private int quantity;

    @Column(name="discount")
    private float discount;
}
