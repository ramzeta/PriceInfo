package com.minsait.msprice.model.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICE_INFO")
public class PriceInfoEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer brandId;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private BigDecimal price;
    private String curr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceInfoEntity)) return false;
        PriceInfoEntity price = (PriceInfoEntity) o;
        return Objects.equals(getId(), price.getId()) &&
                Objects.equals(getBrandId(), price.getBrandId()) &&
                Objects.equals(getStartDate(), price.getStartDate()) &&
                Objects.equals(getEndDate(), price.getEndDate()) &&
                Objects.equals(getPriceList(), price.getPriceList()) &&
                Objects.equals(getProductId(), price.getProductId()) &&
                Objects.equals(getPriority(), price.getPriority()) &&
                Objects.equals(getPrice(), price.getPrice()) &&
                Objects.equals(getCurr(), price.getCurr());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
