package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.entities.dtos.product.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {

    //private ProductRepositories productRepositories;

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductForListingDto> getProducts()
    {
        List<ProductForListingDto>productsInDb = productService.getAll();
        return productsInDb;

    }


   /* public ProductsController(ProductRepositories productRepositories) {
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

*/

    @PostMapping()
    public ResponseEntity add(@RequestBody ProductForAddDto request){
        productService.add(request);
        return new ResponseEntity("Ürün Eklendi", HttpStatus.CREATED);
    }
}
