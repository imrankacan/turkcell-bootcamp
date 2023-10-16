package com.turkcell.spring.starter.business;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.repositories.CategoryRepositories;

import java.util.List;

public class CategoryManager implements CategoryService{
    private final CategoryRepositories categoryRepositories;

    public CategoryManager(CategoryRepositories categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepositories.findAll();
    }
}
