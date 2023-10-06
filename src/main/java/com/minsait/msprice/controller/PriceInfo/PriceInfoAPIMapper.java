package com.minsait.msprice.controller.PriceInfo;

import org.springframework.stereotype.Component;

import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.openapi.model.PriceInfoDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceInfoAPIMapper {

    public PriceInfoEntity mapToEntity(PriceInfoDTO priceInfoDTO) {
        return PriceInfoEntity.builder()
                .brandId(priceInfoDTO.getBrandId())
                .productId(priceInfoDTO.getProductId())
                .startDate(priceInfoDTO.getStartDate())
                .endDate(priceInfoDTO.getEndDate())
                .priority(priceInfoDTO.getPriority())
                .price(priceInfoDTO.getPrice())
                .curr(priceInfoDTO.getCurr())
                .build();
    }

    public PriceInfoDTO mapToDTO(PriceInfoEntity priceInfoEntity) {
        PriceInfoDTO priceInfoDTO = new PriceInfoDTO();
        priceInfoDTO.setBrandId(priceInfoEntity.getBrandId());
        priceInfoDTO.setProductId(priceInfoEntity.getProductId());
        priceInfoDTO.setStartDate(priceInfoEntity.getStartDate());
        priceInfoDTO.setEndDate(priceInfoEntity.getEndDate());
        priceInfoDTO.setPriority(priceInfoEntity.getPriority());
        priceInfoDTO.setPrice(priceInfoEntity.getPrice());
        priceInfoDTO.setCurr(priceInfoEntity.getCurr());
        return priceInfoDTO;

    }
}
