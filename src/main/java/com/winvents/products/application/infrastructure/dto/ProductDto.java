package com.winvents.products.application.infrastructure.dto;

import com.winvents.products.application.domain.Product;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;

    private BigDecimal price;

    private int amountAvailable;

    public Product convert() {
        return new Product()
                .builder()
                .name(name)
                .price(price)
                .amountAvailable(amountAvailable)
                .build();
    }
}
