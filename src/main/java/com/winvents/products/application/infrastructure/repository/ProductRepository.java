package com.winvents.products.application.infrastructure.repository;

import com.winvents.products.application.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
