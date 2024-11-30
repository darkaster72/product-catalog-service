package com.example.product_catalog_service.service;

import com.example.product_catalog_service.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final FakeStoreApi fakeStoreApi;
    private final ProductMapper productMapper;

    public ProductService(FakeStoreApi fakeStoreApi, ProductMapper productMapper) {
        this.fakeStoreApi = fakeStoreApi;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getProducts() {
        return fakeStoreApi.getProducts().stream().map(productMapper::map).toList();
    }

    public Optional<ProductDto> getProductById(Long productId) {
        return fakeStoreApi.getProductById(productId).map(productMapper::map);
    }

    public ProductDto createProduct(ProductDto request) {
        request.setId(1L);
        return request;
    }
}
