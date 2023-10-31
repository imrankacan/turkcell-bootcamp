package com.turkcell.spring.starter.business;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;
import com.turkcell.spring.starter.repositories.CategoryRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryManager implements CategoryService{
    private final CategoryRepositories categoryRepositories; // Controller direk repository e erişememeli.

    public CategoryManager(CategoryRepositories categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }

    @Override
    public List<CategoryForListingDto> getAll() {
        //DTO = Data Transfer Object

        /* Bad Practice
        List<Category> categories = categoryRepositories.findAll();
        List<CategoryForListingDto> categoryForListingDtos = new ArrayList<>();
        //Mapleme: Farklı bir objedeki nesneyi farklı bir objeye alma
        for (Category c:categories) {
            CategoryForListingDto dto = new CategoryForListingDto();
            dto.setCategoryId(c.getCategoryId());
            dto.setCategoryName(c.getCategoryName());
            categoryForListingDtos.add(dto);

        }
        return categoryForListingDtos;

         */
        return categoryRepositories.getForListing();
    }
}
