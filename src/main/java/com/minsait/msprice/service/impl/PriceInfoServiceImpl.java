package com.minsait.msprice.service.impl;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.minsait.msprice.controller.brand.BrandController;
import com.minsait.msprice.exception.PriceNotFoundException;
import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.msprice.model.repository.PriceInfoRepository;
import com.minsait.msprice.service.PriceInfoService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PriceInfoServiceImpl implements PriceInfoService {

    private static final Logger log = LoggerFactory.getLogger(BrandController.class);

    private final PriceInfoRepository repository;

    @Override
    public PriceInfoEntity findPriceInfoByProductIdAndBrandIdAndDate(OffsetDateTime date, Integer productId,
            Integer brandId)
            throws PriceNotFoundException {
        log.info("findPriceInfoByProductIdAndBrandIdAndDate: {}, {}, {}", date, productId, brandId);
        List<PriceInfoEntity> priceInfoList = repository
                .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date,
                        date);
        if (!priceInfoList.isEmpty()) {
            log.info("Price found for given parameters: {}", priceInfoList);
            return priceInfoList.stream()
                    .max(Comparator.comparingInt(PriceInfoEntity::getPriority))
                    .orElseThrow(() -> new PriceNotFoundException("Price not found"));
        }else {
            log.error("Price not found for given parameters");
            throw new PriceNotFoundException("Price not found");
        }
    }
    

}