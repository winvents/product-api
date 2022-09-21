package com.winvents.products.application.usecase.update;

import com.winvents.products.application.domain.Product;
import com.winvents.products.application.infrastructure.exception.DatabaseFieldException;
import com.winvents.products.application.infrastructure.repository.ProductRepository;
import com.winvents.products.application.usecase.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public ProductDto execute(Long productId, ProductDto form) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new DatabaseFieldException("id", "not found"));
        Product updatedProduct = update(existingProduct, form);
        productRepository.save(updatedProduct);
        return form;
    }

    private Product update(Product existingProduct, ProductDto form) {
        existingProduct.setName(form.getName());
        existingProduct.setPrice(form.getPrice());
        existingProduct.setAmountAvailable(form.getAmountAvailable());
        return existingProduct;
    }

}
