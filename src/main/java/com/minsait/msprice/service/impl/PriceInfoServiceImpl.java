package com.minsait.msprice.service.impl;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.msprice.exception.PriceNotFoundException;
import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.msprice.model.repository.PriceInfoRepository;
import com.minsait.msprice.service.PriceInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PriceInfoServiceImpl implements PriceInfoService {

    @Autowired
    private PriceInfoRepository repository;

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