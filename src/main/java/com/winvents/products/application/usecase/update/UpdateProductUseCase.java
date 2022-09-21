package com.winvents.products.application.usecase.update;

import com.winvents.products.application.usecase.dto.ProductDto;

public interface UpdateProductUseCase {

    ProductDto execute(Long productId, ProductDto productDto);

}
