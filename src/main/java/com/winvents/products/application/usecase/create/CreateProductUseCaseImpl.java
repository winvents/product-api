package com.winvents.products.application.usecase.create;

import com.winvents.products.application.domain.Product;
import com.winvents.products.application.infrastructure.dto.ProductDto;
import com.winvents.products.application.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDto execute(ProductDto createProductDto) {
        Product product = createProductDto.convert();
        productRepository.save(product);
        return createProductDto;
    }
}
