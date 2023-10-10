package com.minsait.msprice.controller.brand;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.msprice.model.entity.BrandEntity;
import com.minsait.msprice.service.impl.BrandServiceImpl;
import com.minsait.openapi.api.BrandsApi;
import com.minsait.openapi.model.BrandDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BrandController implements BrandsApi {

    private final BrandServiceImpl brandService;
    private final BrandApiMapper brandMapper;

    @Override
    public ResponseEntity<List<BrandDTO>> getBrands() {
        log.debug("getBrands");
        List<BrandEntity> brands = brandService.getBrands();
        return ResponseEntity.ok(brands.stream().map(brandMapper::mapToDTO).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<BrandDTO> createBrand(BrandDTO brandDto) {
        log.debug("createBrand: {}", brandDto);
        BrandEntity brandEntity = brandMapper.mapToEntity(brandDto);
        brandEntity = brandService.createBrand(brandEntity);
        return ResponseEntity.ok(brandMapper.mapToDTO(brandEntity));
    }

    @Override
    public ResponseEntity<BrandDTO> updateBrand(BrandDTO brandDto) {
        log.debug("updateBrand: {}", brandDto);
        BrandEntity brandEntity = brandMapper.mapToEntity(brandDto);
        brandEntity = brandService.updateBrand(brandEntity);
        return ResponseEntity.ok(brandMapper.mapToDTO(brandEntity));
    }

    @Override
    public ResponseEntity<BrandDTO> getBrandById(Integer brandId) {
        log.debug("getBrandById: {}", brandId);
        BrandEntity brandEntity = brandService.getBrandById(brandId);
        return ResponseEntity.ok(brandMapper.mapToDTO(brandEntity));
    }

    @Override
    public ResponseEntity<Void> deleteBrand(Integer brandId) {
        log.debug("deleteBrand: {}", brandId);
        brandService.deleteBrand(brandId);
        return ResponseEntity.ok().build();
    }

}
