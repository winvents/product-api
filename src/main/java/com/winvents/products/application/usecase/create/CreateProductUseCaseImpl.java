package com.winvents.products.application.usecase.create;

import com.winvents.products.application.domain.Cathegory;
import com.winvents.products.application.domain.Product;
import com.winvents.products.application.infrastructure.dto.ProductDto;
import com.winvents.products.application.infrastructure.exception.DatabaseFieldException;
import com.winvents.products.application.infrastructure.repository.CathegoryRepository;
import com.winvents.products.application.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CathegoryRepository cathegoryRepository;

    @Override
    public ProductDto execute(ProductDto createProductDto) {
        Cathegory cathegory = cathegoryRepository.findById(createProductDto.getCathegoryId()).orElseThrow(() -> new DatabaseFieldException("cathegory", "not found."));
        Product product = createProductDto.convert(cathegory);
        productRepository.save(product);
        return createProductDto;
    }
}
