package com.minsait.msprice.controller.product;

import org.mapstruct.Mapper;

import com.minsait.msprice.model.entity.ProductEntity;
import com.minsait.openapi.model.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductApiMapper {
    
        ProductEntity mapToEntity(ProductDTO productDTO);
    
        ProductDTO mapToDTO(ProductEntity productEntity);
}
