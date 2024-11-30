package com.example.product_catalog_service.service;

import com.example.product_catalog_service.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public List<ProductDto> getProducts(){
        return List.of(new ProductDto());
    }

    public Optional<ProductDto> getProductById(Long productId) {
        return Optional.of(new ProductDto());
    }

    public ProductDto createProduct(ProductDto request) {
        request.setId(1L);
        return request;
    }
}
