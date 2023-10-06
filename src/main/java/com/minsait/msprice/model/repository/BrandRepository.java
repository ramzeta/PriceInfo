package com.minsait.msprice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minsait.msprice.model.entity.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
}
