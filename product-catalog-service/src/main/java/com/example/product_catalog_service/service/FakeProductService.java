package com.example.product_catalog_service.service;

import com.example.product_catalog_service.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FakeProductService implements ProductService {
    private final FakeStoreApi fakeStoreApi;
    private final ProductMapper productMapper;

    public FakeProductService(FakeStoreApi fakeStoreApi, ProductMapper productMapper) {
        this.fakeStoreApi = fakeStoreApi;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getProducts() {
        return fakeStoreApi.getProducts().stream().map(productMapper::map).toList();
    }

    @Override
    public Optional<ProductDto> getProductById(Long productId) {
        return fakeStoreApi.getProductById(productId).map(productMapper::map);
    }

    @Override
    public ProductDto createProduct(ProductDto request) {
        request.setId(1L);
        return request;
    }
}
