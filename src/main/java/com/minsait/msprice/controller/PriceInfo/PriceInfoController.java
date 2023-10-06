package com.minsait.msprice.controller.PriceInfo;

import java.time.OffsetDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.msprice.service.impl.PriceInfoServiceImpl;
import com.minsait.openapi.api.PriceInfoApi;
import com.minsait.openapi.model.PriceInfoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PriceInfoController implements PriceInfoApi {

    @Autowired
    private PriceInfoServiceImpl priceInfoService;

    private final PriceInfoAPIMapper priceInfoAPIMapper;

    @Override
    public ResponseEntity<PriceInfoDTO> getPriceInfo(
            @Valid OffsetDateTime applicationDate,
            @Valid Integer productId,
            @Valid Integer brandId) {
        log.info("REST request to get PriceInfo : {}", applicationDate, productId, brandId);
        PriceInfoEntity priceInfoEntity = priceInfoService.findPriceInfoByProductIdAndBrandIdAndDate(applicationDate,
                productId, brandId);
        PriceInfoDTO priceInfoDTO = priceInfoAPIMapper.mapToDTO(priceInfoEntity);
        return ResponseEntity.ok(priceInfoDTO);
    }

}
