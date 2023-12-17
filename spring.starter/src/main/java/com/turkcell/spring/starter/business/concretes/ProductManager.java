package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.core.exceptions.types.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.Supplier;
import com.turkcell.spring.starter.entities.dtos.product.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import com.turkcell.spring.starter.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductRepository productRepositories;

    @Autowired
    public ProductManager(ProductRepository productRepositories) {

        this.productRepositories = productRepositories;
    }

    @Override
    public List<ProductForListingDto> getAll() {

        return productRepositories.getForListing();
    }

    @Override
    public void add(ProductForAddDto request) {
        productWithSameNameShouldNotExist(request.getProductName());

        Product newProduct = Product.builder()
                .productName(request.getProductName())
                .unitPrice(request.getUnitPrice())
                .unitsInStock(request.getUnitsInStock())
                .category(Category.builder().categoryId(request.getCategoryId()).build())
                .supplier(Supplier.builder().supplierId(request.getSupplierId()).build())
                .discontinued(0)
                .build();
        productRepositories.save(newProduct);



    }

    private void productWithSameNameShouldNotExist(String productName) {
        Product productWithSameName = productRepositories.findByProductName(productName);
        if(productWithSameName!=null)
            throw new BusinessException("Aynı İsimden İkinci Ürün Eklenemez");
    }
}
