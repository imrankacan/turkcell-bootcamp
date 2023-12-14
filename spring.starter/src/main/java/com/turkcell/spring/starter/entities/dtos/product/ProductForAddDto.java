package com.turkcell.spring.starter.entities.dtos.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductForAddDto {
    @Min(3)
    private String productName;

    @NotNull
    @Min(1)
    private short supplierId;

    @NotNull
    @Min(1)
    private int categoryId;

    @NotNull //Boş Geçilemez
    @Min(1) // Sıfırdan Küçük Olamaz
    private float unitPrice;
    @NotNull
    @Min(1)
    private int unitsInStock;

}
