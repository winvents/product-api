package com.winvents.products.application.infrastructure.controller;

import com.winvents.products.application.usecase.create.CreateProductUseCase;
import com.winvents.products.application.usecase.delete.DeleteProductUseCase;
import com.winvents.products.application.usecase.dto.ProductDto;
import com.winvents.products.application.usecase.list.ListProductsUseCase;
import com.winvents.products.application.usecase.update.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;


    @PostMapping
    @Transactional
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto form) {
        ProductDto productDto = createProductUseCase.execute(form);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> listProducts() {
        List<ProductDto> products = listProductsUseCase.execute();
        if (products == null || products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDto form) {
        ProductDto updatedProduct = updateProductUseCase.execute(id, form);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        deleteProductUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
