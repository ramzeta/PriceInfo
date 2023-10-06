package com.minsait.msprice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.minsait.msprice.model.entity.ProductEntity;

@Service
public interface ProductService {
    
    List<ProductEntity> getProducts();
    ProductEntity createProduct(ProductEntity product);
    ProductEntity updateProduct(ProductEntity product);
    ProductEntity getProductById(Integer productId);
    void deleteProduct(Integer productId);
}
