package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.entities.dtos.ProductForListingDto;
import com.turkcell.spring.starter.repositories.ProductRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductRepositories productRepositories;

    public ProductManager(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    @Override
    public List<ProductForListingDto> getAll() {
        return productRepositories.getForListing();
    }
}
