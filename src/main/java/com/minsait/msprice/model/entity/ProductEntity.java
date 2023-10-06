package com.minsait.msprice.model.entity;

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
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProductEntity))
            return false;
        ProductEntity that = (ProductEntity) o;
        return getProductId().equals(that.getProductId()) &&
                getProductName().equals(that.getProductName());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getProductId(), getProductName());
    }

}
