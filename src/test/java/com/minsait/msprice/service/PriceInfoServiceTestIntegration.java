package com.minsait.msprice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.minsait.msprice.model.entity.PriceInfoEntity;
import com.minsait.msprice.service.impl.PriceInfoServiceImpl;




@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PriceInfoServiceTestIntegration {

    @Autowired
    private PriceInfoServiceImpl priceInfoService;



    @BeforeEach
    public void setUp() {
        // Preparar la base de datos
    }
    
    @ParameterizedTest
    @CsvSource({
            "2020-06-14T10:00:00.0Z, 35455, 1, 35.50",
            "2020-06-14T16:00:00.0Z, 35455, 1, 25.45",
            "2020-06-14T21:00:00.0Z, 35455, 1, 35.50",
            "2020-06-15T10:00:00.0Z, 35455, 1, 30.50",
            "2020-06-16T21:00:00.0Z, 35455, 1, 38.95",
    })
    public void testGetPriceInfoWithAllCasuistics(String date, int productId, int brandId, double precio) {
        PriceInfoEntity priceInfo = priceInfoService
                .findPriceInfoByProductIdAndBrandIdAndDate(OffsetDateTime.parse(date), productId, brandId);
        assertNotNull(priceInfo);
        assertEquals(precio, priceInfo.getPrice().doubleValue());

    }
    
}