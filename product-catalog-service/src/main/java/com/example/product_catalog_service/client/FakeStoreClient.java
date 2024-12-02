package com.example.product_catalog_service.client;

import com.example.product_catalog_service.dto.FakeStoreProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "fakeStoreClient", url = "https://fakestoreapi.com")
public interface FakeStoreClient {
    @GetMapping("/products/{id}")
    ResponseEntity<Optional<FakeStoreProductDto>> getProductById(@PathVariable("id") Long id);

    @GetMapping("/products")
    ResponseEntity<List<FakeStoreProductDto>> getProducts();

    @PutMapping("/products/{id}")
    ResponseEntity<FakeStoreProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody FakeStoreProductDto body);
}
