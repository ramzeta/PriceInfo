package com.minsait.msprice.controller.priceInfo;

import java.time.OffsetDateTime;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.msprice.controller.brand.BrandController;
import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.msprice.service.impl.PriceInfoServiceImpl;
import com.minsait.openapi.api.PriceInfoApi;
import com.minsait.openapi.model.PriceInfoDTO;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class PriceInfoController implements PriceInfoApi {

    private static final Logger log = LoggerFactory.getLogger(BrandController.class);

    private final PriceInfoServiceImpl priceInfoService;
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
