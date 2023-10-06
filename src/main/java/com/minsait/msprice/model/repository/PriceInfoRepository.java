package com.minsait.msprice.model.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minsait.msprice.model.entity.PriceInfoEntity;

@Repository
public interface PriceInfoRepository extends JpaRepository<PriceInfoEntity, Integer> {

    List<PriceInfoEntity> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Integer productId, Integer brandId, OffsetDateTime date1DateTime, OffsetDateTime date2DateTime);

}
