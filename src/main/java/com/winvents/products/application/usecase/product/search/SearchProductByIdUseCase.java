package com.winvents.products.application.usecase.product.search;

import com.winvents.products.application.infrastructure.dto.ProductDto;

public interface SearchProductByIdUseCase {

    ProductDto execute(Long id);

}
