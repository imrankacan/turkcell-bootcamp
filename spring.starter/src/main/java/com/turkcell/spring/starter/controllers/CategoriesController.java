package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.CategoryService;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
//localhost:8080/categories/[action]
public class CategoriesController {

    //Business
    //CategoriyService
    //Dependecy Injection


    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }


    //Spring IoC => Bağımlılıkların Çözümlenmesi


    @GetMapping()
    public List<CategoryForListingDto> getCategories()
    {
        //List<Category>categoriesInDb = categoryRepositories.findAll();
        //return categoriesInDb;
        List<CategoryForListingDto>categoriesInDb = categoryService.getAll();
        return categoriesInDb;

    }

    @GetMapping("getByName")
    public List<Category> getCategoriesByName(@RequestParam("name")String name)
    {
        //List<Category> categories = categoryRepositories.findByCategoryName(name);
        //return categories;
        //http://localhost:8080/categories/getByName?name=Seafood
        // List<Category> findByName(String name); (Repositories)
        return null;

    }
    @GetMapping("search")
    public List<Category> searchNative(@RequestParam("name")String name)
    {
        //List<Category> categories = categoryRepositories.search(name);
        //return categories;
        return null;
    }

    @GetMapping("getByLessId")
    public List<Category> getCategoriesIdLessThan(@RequestParam("id")int id)
    {
        //List<Category> categories = categoryRepositories.findByCategoryIdLessThan(id);
        //return categories;
        //http://localhost:8080/categories/getByLessId?id=15
        //List<Category> findByCategoryIdLessThan(int id); // Kategori id si verilen id den küçük olanlar
        return null;


    }

    @GetMapping("getById")
    public Category getCategoryById(@RequestParam("id") int id){
        //Category category = categoryRepositories.findById(id).orElseThrow(); //Girilen id ye göre veri getirir, id ye ait veri yoksa hata fırlatır
        //return category;
        return null;
    }

    @GetMapping("created")
    public ResponseEntity add(@RequestBody Category category){
        //categoryRepositories.save(category);
        return new ResponseEntity("Kategory Eklendi", HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody CategoryForAddDto request){
        //Manuel Mapleme
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        //AutoMapper => ModelMapper
        return new ResponseEntity("Kategori Eklendi", HttpStatus.CREATED);


    }

}
