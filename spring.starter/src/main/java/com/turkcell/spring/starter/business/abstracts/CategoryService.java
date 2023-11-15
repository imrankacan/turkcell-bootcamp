package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;

import java.util.List;
//Soyut Classlar
public interface CategoryService {
    //Servisler entitiyleri değil dto ları kullanmalı. (Servisler dışarıya verilen değerler olduğu için)
    List<CategoryForListingDto> getAll();
}
