package com.winvents.products.application.usecase.product.delete;

import com.winvents.products.application.domain.Product;
import com.winvents.products.application.infrastructure.exception.DatabaseFieldException;
import com.winvents.products.application.infrastructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public void execute(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new DatabaseFieldException("id", "not found"));
        productRepository.delete(product);
    }

}
