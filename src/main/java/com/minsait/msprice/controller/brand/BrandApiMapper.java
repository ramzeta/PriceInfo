package com.minsait.msprice.controller.brand;

import org.mapstruct.Mapper;

import com.minsait.msprice.model.entity.BrandEntity;
import com.minsait.openapi.model.BrandDTO;

@Mapper(componentModel = "spring")
public interface BrandApiMapper {

    BrandEntity mapToEntity(BrandDTO brandDTO);

    BrandDTO mapToDTO(BrandEntity brandEntity);

}
