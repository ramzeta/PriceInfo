package com.minsait.msprice.controller.Brand;

import org.springframework.stereotype.Component;

import com.minsait.msprice.model.entity.BrandEntity;
import com.minsait.openapi.model.BrandDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BrandApiMapper {

    public BrandEntity mapToEntity(BrandDTO brandtDTO) {
        return BrandEntity.builder()
                .brandId(brandtDTO.getBrandId())
                .brandName(brandtDTO.getBrandName())
                .build();
    }

    public BrandDTO mapToDTO(BrandEntity brandEntity) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setBrandId(brandEntity.getBrandId());
        brandDTO.setBrandName(brandEntity.getBrandName());
        return brandDTO;

    }
}
