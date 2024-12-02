package com.example.product_catalog_service.service;

import com.example.product_catalog_service.client.FakeStoreClient;
import com.example.product_catalog_service.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FakeProductService implements ProductService {
    private final FakeStoreClient fakeStoreClient;
    private final ProductMapper productMapper;

    public FakeProductService(FakeStoreClient fakeStoreClient, ProductMapper productMapper) {
        this.fakeStoreClient = fakeStoreClient;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getProducts() {
        return Objects.requireNonNull(fakeStoreClient.getProducts().getBody()).stream().map(productMapper::map).toList();
    }

    @Override
    public Optional<ProductDto> getProductById(Long productId) {
        return fakeStoreClient.getProductById(productId).getBody().map(productMapper::map);
    }

    @Override
    public ProductDto createProduct(ProductDto request) {
        request.setId(1L);
        return request;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto request) {
        var body = productMapper.map(request);
        var updated = fakeStoreClient.updateProductById(id, body).getBody();
        return productMapper.map(updated);
    }
}
