package com.winvents.products.application.infrastructure.dto;

import com.winvents.products.application.domain.Cathegory;
import com.winvents.products.application.domain.Product;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private int amountAvailable;

    private String description;

    @NotNull
    private Long cathegoryId;

    public Product convert(Cathegory cathegory) {
        return new Product()
                .builder()
                .name(name)
                .price(price)
                .amountAvailable(amountAvailable)
                .cathegory(cathegory)
                .description(description)
                .build();
    }
}
