package com.minsait.msprice.service.impl;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.minsait.msprice.exception.PriceException;
import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.msprice.model.repository.PriceInfoRepository;
import com.minsait.msprice.service.PriceInfoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceInfoServiceImpl implements PriceInfoService {
    
    private final PriceInfoRepository repository;

    @Override
    public PriceInfoEntity findPriceInfoByProductIdAndBrandIdAndDate(OffsetDateTime date, Integer productId,
            Integer brandId)
            throws PriceException {
        log.info("findPriceInfoByProductIdAndBrandIdAndDate: {}, {}, {}", date, productId, brandId);
        List<PriceInfoEntity> priceInfoList = repository
                .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date,
                        date);
        if (!priceInfoList.isEmpty()) {
            log.info("Price found for given parameters: {}", priceInfoList);
            return priceInfoList.stream()
                    .max(Comparator.comparingInt(PriceInfoEntity::getPriority))
                    .orElseThrow(() -> new PriceException("Price not found"));
        } else {
            log.error("Price not found for given parameters");
            throw new PriceException("Price not found");
        }
    }

}