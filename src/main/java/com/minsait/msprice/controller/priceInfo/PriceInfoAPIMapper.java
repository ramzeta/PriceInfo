package com.minsait.msprice.controller.priceInfo;

import org.mapstruct.Mapper;

import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.openapi.model.PriceInfoDTO;

@Mapper(componentModel = "spring")
public interface PriceInfoAPIMapper {

    PriceInfoEntity mapToEntity(PriceInfoDTO priceInfoDTO);

    PriceInfoDTO mapToDTO(PriceInfoEntity priceInfoEntity);

}

