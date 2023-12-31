package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {
// 21 Eylül
   // List<Product> findByProductName(String ProductName);


    //Kontrol Ettt!!
    @Query(value="SELECT new " +
            "com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto(p.productId, p.productName, p.quantityPerUnit, p.unitPrice, p.unitsInStock, p.unitsOnOrder) From Product p")
    List<ProductForListingDto> getForListing();

    Product findByProductName(String productName);
}
