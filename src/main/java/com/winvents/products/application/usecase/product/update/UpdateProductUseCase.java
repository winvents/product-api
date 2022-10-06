package com.winvents.products.application.usecase.product.update;

import com.winvents.products.application.infrastructure.dto.ProductDto;

public interface UpdateProductUseCase {

    ProductDto execute(Long productId, ProductDto productDto);

}
