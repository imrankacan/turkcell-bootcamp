package com.turkcell.spring.starter.business;

import com.turkcell.spring.starter.entities.dtos.ProductForListingDto;

import java.util.List;

public interface ProductService {
    List<ProductForListingDto> getAll();
}
