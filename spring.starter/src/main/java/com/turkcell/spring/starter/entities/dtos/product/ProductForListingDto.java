package com.turkcell.spring.starter.entities.dtos.product;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductForListingDto {
    private int productId;
    private String productName;
    private String quantityPerUnit;
    private float unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
}
