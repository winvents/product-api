package com.winvents.products.application.infrastructure.repository;

import com.winvents.products.application.domain.Cathegory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CathegoryRepository extends JpaRepository<Cathegory, Long> {
}
