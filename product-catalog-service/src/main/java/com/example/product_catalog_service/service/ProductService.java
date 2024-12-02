package com.example.product_catalog_service.service;

import com.example.product_catalog_service.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getProducts();

    Optional<ProductDto> getProductById(Long productId);

    ProductDto createProduct(ProductDto request);

    ProductDto updateProduct(Long id, ProductDto request);
}
