package com.turkcell.spring.starter.business;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;

import java.util.List;

public interface CategoryService {
    //Servisler entitiyleri değil dto ları kullanmalı. (Servisler dışarıya verilen değerler olduğu için)
    List<CategoryForListingDto> getAll();
}
