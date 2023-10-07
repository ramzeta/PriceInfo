package com.minsait.msprice.controller.product;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.msprice.controller.brand.BrandController;
import com.minsait.msprice.model.entity.ProductEntity;
import com.minsait.msprice.service.impl.ProductServiceImpl;
import com.minsait.openapi.api.ProductsApi;
import com.minsait.openapi.model.ProductDTO;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(BrandController.class);

    private final ProductServiceImpl productService;
    private final ProductApiMapper productMapper;

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts() {
        log.debug("getProducts");
        List<ProductEntity> products = productService.getProducts();
        return ResponseEntity.ok(products.stream().map(productMapper::mapToDTO).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDto) {
        log.debug("createProduct: {}", productDto);
        ProductEntity productEntity = productMapper.mapToEntity(productDto);
        productEntity = productService.createProduct(productEntity);
        return ResponseEntity.ok(productMapper.mapToDTO(productEntity));
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDto) {
        log.debug("updateProduct: {}", productDto);
        ProductEntity productEntity = productMapper.mapToEntity(productDto);
        productEntity = productService.updateProduct(productEntity);
        return ResponseEntity.ok(productMapper.mapToDTO(productEntity));
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(Integer productId) {
        log.debug("getProductById: {}", productId);
        ProductEntity productEntity = productService.getProductById(productId);
        return ResponseEntity.ok(productMapper.mapToDTO(productEntity));
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer productId) {
        log.debug("deleteProduct: {}", productId);
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}