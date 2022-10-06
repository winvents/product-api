package com.winvents.products.application.usecase.product.list;

import com.winvents.products.application.infrastructure.dto.ProductDto;

import java.util.List;

public interface ListProductsUseCase {

    List<ProductDto> execute();

}
