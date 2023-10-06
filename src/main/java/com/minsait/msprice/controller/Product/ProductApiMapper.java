package com.minsait.msprice.controller.Product;

import org.springframework.stereotype.Component;

import com.minsait.msprice.model.entity.ProductEntity;
import com.minsait.openapi.model.ProductDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductApiMapper {

    public ProductEntity mapToEntity(ProductDTO productDTO) {
        return ProductEntity.builder()
                .productId(productDTO.getProductId())
                .productId(productDTO.getProductId())
                .productName(productDTO.getProductName())
                .build();
    }

    public ProductDTO mapToDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setProductName(productEntity.getProductName());
        return productDTO;

    }
}
