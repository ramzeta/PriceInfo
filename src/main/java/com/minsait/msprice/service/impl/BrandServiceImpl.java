package com.minsait.msprice.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.minsait.msprice.controller.brand.BrandController;
import com.minsait.msprice.exception.BrandNotFoundException;
import com.minsait.msprice.model.entity.BrandEntity;
import com.minsait.msprice.model.repository.BrandRepository;
import com.minsait.msprice.service.BrandService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private static final Logger log = LoggerFactory.getLogger(BrandController.class);

    private final BrandRepository repository;

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