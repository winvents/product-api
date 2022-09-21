package com.winvents.products.application.usecase.list;

import com.winvents.products.application.usecase.dto.ProductDto;

import java.util.List;

public interface ListProductsUseCase {

    List<ProductDto> execute();

}
