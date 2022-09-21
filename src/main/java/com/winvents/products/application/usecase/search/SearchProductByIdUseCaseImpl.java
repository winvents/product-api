package com.winvents.products.application.usecase.search;

import com.winvents.products.application.domain.Product;
import com.winvents.products.application.infrastructure.dto.ProductDto;
import com.winvents.products.application.infrastructure.exception.DatabaseFieldException;
import com.winvents.products.application.infrastructure.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchProductByIdUseCaseImpl implements SearchProductByIdUseCase {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto execute(Long productId) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new DatabaseFieldException("id", "not found"));
        ModelMapper modelMapper = new ModelMapper();
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;

    }
}
