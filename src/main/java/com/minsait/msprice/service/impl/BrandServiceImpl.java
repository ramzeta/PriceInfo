package com.minsait.msprice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.msprice.exception.BrandNotFoundException;
import com.minsait.msprice.model.entity.BrandEntity;
import com.minsait.msprice.model.repository.BrandRepository;
import com.minsait.msprice.service.BrandService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository repository;

    @Override
    public List<BrandEntity> getBrands() {
        Optional<List<BrandEntity>> brands = Optional.ofNullable(repository.findAll());
        if (brands.isEmpty()) {
            log.error("Brand not found");
            throw new BrandNotFoundException("Brand not found");
        }else {
            log.debug("getBrands");
            return brands.get();
        }
        
        
    }

    @Override
    public BrandEntity createBrand(BrandEntity brand) {
        Optional <BrandEntity> brandOptional = repository.findById(brand.getBrandId());
        if (brandOptional.isPresent()) {
            log.error("Brand already exists");
            throw new BrandNotFoundException("Brand already exists");
        } else {
            log.debug("createBrand: {}", brand);
            return repository.saveAndFlush(brand);
        }
    }

    @Override
    public BrandEntity updateBrand(BrandEntity brand) {
        Optional<BrandEntity> brandOptional = repository.findById(brand.getBrandId());
        if (!brandOptional.isPresent()) {
            log.error("Brand not found");
            throw new BrandNotFoundException("Brand not found");
        }else{
            log.debug("updateBrand: {}", brand);
            return repository.saveAndFlush(brand);
        }
    }

    @Override
    public BrandEntity getBrandById(Integer brandId) {
        Optional<BrandEntity> brand = repository.findById(brandId);
        if (!brand.isPresent()) {
            log.error("Brand not found");
            throw new BrandNotFoundException("Brand not found");
        }else{
            log.debug("getBrandById: {}", brandId);
            return repository.findById(brandId).orElse(null);
        }
            
    }

    @Override
    public void deleteBrand(Integer brandId) {
        Optional<BrandEntity> brand = repository.findById(brandId);
        if (!brand.isPresent()) {
            log.error("Brand not found");
            throw new BrandNotFoundException("Brand not found");
        }else{
            log.debug("deleteBrand: {}", brandId);
            repository.deleteById(brandId);
        }
    }



}