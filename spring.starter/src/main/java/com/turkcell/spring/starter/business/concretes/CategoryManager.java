package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.CategoryService;
import com.turkcell.spring.starter.core.exceptions.types.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForListingDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForUpdateDto;
import com.turkcell.spring.starter.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
//Somut Classlar
@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepositories; // Controller direk repository e erişememeli.
    private  final MessageSource messageSource;

  /*  public CategoryManager(CategoryRepository categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }
*/
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

    @Override
    public void add(CategoryForAddDto request) {


        categoryWithSameNameSouldNotExist(request.getCategoryName());
        Category category = Category.builder().build();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        //Mapleme İşlemi Business te
        categoryRepositories.save(category);
    }

    @Override
    public void delete(int id) {

        Category categoryToDelete = returnCategoryByIdIfExists(id);
        categoryRepositories.delete(categoryToDelete);
    }

    @Override
    public void update(CategoryForUpdateDto request) {
        Category categoryToUpdate = returnCategoryByIdIfExists(request.getId());

        categoryToUpdate.setDescription(request.getDescription());
        categoryToUpdate.setCategoryName(request.getCategoryName());

        categoryRepositories.save(categoryToUpdate);

    }

    private void categoryWithSameNameSouldNotExist(String categoryName){
        //Business Rule => Aynı isimde iki kategory olmamalı

        Category categoryWithSameName = categoryRepositories.findByCategoryName(categoryName);
        if(categoryWithSameName !=null) {
            //Business Kuralı Hatası
            throw new BusinessException("Aynı kategori isminden iki adet bulunamaz");
        }

    }

    private Category returnCategoryByIdIfExists(int id){
        Category categoryToDelete = categoryRepositories.findById(id).orElse(null);
        if(categoryToDelete==null) {
            throw new BusinessException(messageSource.getMessage("categoryDoesNotExistWithGivenId",new Object[]{id}, LocaleContextHolder.getLocale()));
        }
        return categoryToDelete;
        }
}
