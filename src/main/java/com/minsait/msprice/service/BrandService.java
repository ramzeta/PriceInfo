package com.minsait.msprice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.minsait.msprice.model.entity.BrandEntity;

@Service
public interface BrandService {

    List<BrandEntity> getBrands();
    BrandEntity createBrand(BrandEntity brand);
    BrandEntity updateBrand(BrandEntity brand);
    BrandEntity getBrandById(Integer brandId);
    void deleteBrand(Integer brandId);

}
