package com.minsait.msprice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minsait.msprice.exception.BrandException;
import com.minsait.msprice.model.entity.BrandEntity;
import com.minsait.msprice.model.repository.BrandRepository;
import com.minsait.msprice.service.BrandService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;

    @Override
    public List<BrandEntity> getBrands() {
        Optional<List<BrandEntity>> brandOptional = Optional.ofNullable(repository.findAll());
        if (brandOptional.isPresent()) {
            log.debug("getBrands");
            return brandOptional.get();
        } else {
            log.error("Brand not found");
            throw new BrandException("Brand not found");
        }
    }

    @Override
    public BrandEntity createBrand(BrandEntity brand) {
        Optional<BrandEntity> brandOptional = repository.findById(brand.getBrandId());
        if (brandOptional.isPresent()) {
            log.error("Brand already exists");
            throw new BrandException("Brand already exists");
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
            throw new BrandException("Brand not found");
        } else {
            log.debug("updateBrand: {}", brand);
            return repository.saveAndFlush(brand);
        }
    }

    @Override
    public BrandEntity getBrandById(Integer brandId) {
        Optional<BrandEntity> brand = repository.findById(brandId);
        if (brand.isPresent()) {
            log.debug("getBrandById: {}", brandId);
            return repository.findById(brandId).orElse(null);
        } else {
            log.error("Brand not found");
            throw new BrandException("Brand not found");
        }
    }

    @Override
    public void deleteBrand(Integer brandId) {
        Optional<BrandEntity> brand = repository.findById(brandId);
        if (brand.isPresent()) {
            log.debug("deleteBrand: {}", brandId);
            repository.deleteById(brandId);
        } else {
            log.error("Brand not found");
            throw new BrandException("Brand not found");
        }
    }

}