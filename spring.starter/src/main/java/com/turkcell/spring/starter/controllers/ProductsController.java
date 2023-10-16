package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.repositories.ProductRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {

    private ProductRepositories productRepositories;
    public ProductsController(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }
    @GetMapping("getById")
    public Product getProductById(@RequestParam("id") int id){
        Product product = productRepositories.findById(id).orElseThrow(); //Girilen id ye göre veri getirir, id ye ait veri yoksa hata fırlatır
        return product;
    }

    @GetMapping()
    public ResponseEntity add(@RequestBody Product product){
        productRepositories.save(product);
        return new ResponseEntity("Ürün Eklendi", HttpStatus.CREATED);
    }

    //21 Eylül
    @GetMapping("getByProductName")
    public List<Product> getCategoriesIdLessThan(@RequestParam("name")String ProductName)
    {
        List <Product> products = productRepositories.findByProductName(ProductName);
        return products;
    }
    //http://localhost:8080/products/getByProductName?name=Chai



}
