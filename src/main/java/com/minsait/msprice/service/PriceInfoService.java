package com.minsait.msprice.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.minsait.msprice.model.entity.PriceInfoEntity;

@Service
public interface PriceInfoService {
    
    PriceInfoEntity findPriceInfoByProductIdAndBrandIdAndDate(OffsetDateTime date, Integer productId, Integer brandId);

}
