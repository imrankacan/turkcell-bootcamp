package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Table (name = "products")
@Entity
public class Product {

    @Id
    @Column(name="product_id")
    private int productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="supplier_id")
    private int supplierId;

   /* @Column(name="category_id")
    private int categoryId;*/

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @Column(name="unit_price")
    private float unitPrice;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @Column(name="units_on_order")
    private int unitsOnOrder;

    @Column(name="reorder_level")
    private int reorderLevel;

    @Column(name="discontinued")
    private int discontinued;

    @ManyToOne
    @JoinColumn (name="category_id") // İlişki sağlanılan column
    @JsonIgnore //Bu alanı json a yazma(Sonsuz döngüye girmemesi için)
    private Category category;

}
//ORM = Object Relation Mapping
// Sql tablolarını bir class gibi kullanmamızı sağlar
