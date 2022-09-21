package com.winvents.products.application.usecase.create;

import com.winvents.products.application.usecase.dto.ProductDto;

public interface CreateProductUseCase {

    ProductDto execute(ProductDto createProductDto);
}
