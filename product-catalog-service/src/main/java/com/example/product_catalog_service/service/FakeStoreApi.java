package com.example.product_catalog_service.service;

import com.example.product_catalog_service.dto.FakeStoreProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


public interface FakeStoreApi {
    @GetMapping("/products/{id}")
    Optional<FakeStoreProductDto> getProductById(@PathVariable("id") Long id);

    @GetMapping("/products")
    List<FakeStoreProductDto> getProducts();
}
