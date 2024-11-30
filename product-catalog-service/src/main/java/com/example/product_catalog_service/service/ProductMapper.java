package com.example.product_catalog_service.service;

import com.example.product_catalog_service.dto.CategoryDto;
import com.example.product_catalog_service.dto.FakeStoreProductDto;
import com.example.product_catalog_service.dto.ProductDto;
import com.example.product_catalog_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "imageUrl", source = "image")
    ProductDto map(FakeStoreProductDto product);

    default CategoryDto map(String categoryName) {
        var category = new CategoryDto();
        category.setName(categoryName);
        return category;
    }

    ProductDto map(Product product);
}
