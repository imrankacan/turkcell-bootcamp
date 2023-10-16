package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepositories extends JpaRepository<Product,Integer> {
// 21 Eylül
    List<Product> findByProductName(String ProductName);
}
