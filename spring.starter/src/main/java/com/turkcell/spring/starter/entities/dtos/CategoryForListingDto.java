package com.turkcell.spring.starter.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForListingDto {
    private int categoryId;
    private String categoryName;
}
