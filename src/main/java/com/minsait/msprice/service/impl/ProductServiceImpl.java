package com.minsait.msprice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.msprice.exception.ProductNotFoundException;
import com.minsait.msprice.model.entity.ProductEntity;
import com.minsait.msprice.model.repository.ProductRepository;
import com.minsait.msprice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductEntity> getProducts() {
        Optional<List<ProductEntity>> products = Optional.ofNullable(repository.findAll());
        if (products.isEmpty()) {
            log.error("Product not found");
            throw new ProductNotFoundException("Product not found");
        } else {
            return products.get();
        }
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        Optional<ProductEntity> productOptional =
                repository.findById(product.getProductId());
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
        Optional<ProductEntity> productOptional =
                repository.findById(product.getProductId());
        if (!productOptional.isPresent()) {
            log.error("Product not found");
            throw new ProductNotFoundException("Product not found");
        }else {
            log.debug("updateProduct: {}", product);
            return repository.saveAndFlush(product);
        }
    }

    @Override
    public ProductEntity getProductById(Integer productId) {
        Optional<ProductEntity> product = repository.findById(productId);
        if (product.isEmpty()) {
            log.error("Product not found");
            throw new ProductNotFoundException("Product not found");
        } else {
            log.debug("getProductById: {}", productId);
            return repository.findById(productId).orElse(null);
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
