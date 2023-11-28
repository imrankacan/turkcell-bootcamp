package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForListingDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForUpdateDto;

import java.util.List;
//Soyut Classlar
public interface CategoryService {
    //Servisler entitiyleri değil dto ları kullanmalı. (Servisler dışarıya verilen değerler olduğu için)
    List<CategoryForListingDto> getAll();

    void add(CategoryForAddDto request);
    void delete(int id);
    void update(CategoryForUpdateDto request);

}
