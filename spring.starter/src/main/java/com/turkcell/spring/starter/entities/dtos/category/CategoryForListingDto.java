package com.turkcell.spring.starter.entities.dtos.category;

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
