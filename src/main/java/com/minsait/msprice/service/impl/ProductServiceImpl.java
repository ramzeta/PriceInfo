package com.minsait.msprice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minsait.msprice.exception.ProductNotFoundException;
import com.minsait.msprice.model.entity.ProductEntity;
import com.minsait.msprice.model.repository.ProductRepository;
import com.minsait.msprice.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<ProductEntity> getProducts() {
        Optional<List<ProductEntity>> products = Optional.ofNullable(repository.findAll());
        if (products.isPresent()) {
            return products.get();
        } else {
            log.error("Product not found");
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        Optional<ProductEntity> productOptional = repository.findById(product.getProductId());
        if (productOptional.isPresent()) {
            log.error("Product already exists");
            throw new ProductNotFoundException("Product already exists");
        } else {
            log.debug("createProduct: {}", product);
            return repository.saveAndFlush(product);
        }
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        Optional<ProductEntity> productOptional = repository.findById(product.getProductId());
        if (productOptional.isPresent()) {
            log.debug("updateProduct: {}", product);
            return repository.saveAndFlush(product);
        } else {
            log.error("Product not found");
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public ProductEntity getProductById(Integer productId) {
        Optional<ProductEntity> product = repository.findById(productId);
        if (product.isPresent()) {
            log.debug("getProductById: {}", productId);
            return repository.findById(productId).orElse(null);
        } else {
            log.error("Product not found");
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        Optional<ProductEntity> productOptional = repository.findById(productId);
        if (productOptional.isPresent()) {
            repository.deleteById(productId);
        } else {
            log.error("Product not found");
            throw new ProductNotFoundException("Product not found");
        }
    }

}
