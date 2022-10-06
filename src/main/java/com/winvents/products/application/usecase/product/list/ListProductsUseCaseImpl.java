package com.winvents.products.application.usecase.product.list;

import com.winvents.products.application.domain.Product;
import com.winvents.products.application.infrastructure.dto.ProductDto;
import com.winvents.products.application.infrastructure.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsUseCaseImpl implements ListProductsUseCase {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> execute() {

        List<Product> products = productRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();

        List<ProductDto> productsDto = products
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();

        return productsDto;

    }
}
