package com.winvents.products.application.usecase.cathegory.create;

import com.winvents.products.application.domain.Cathegory;
import com.winvents.products.application.infrastructure.repository.CathegoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCathegoryUseCaseImpl implements CreateCathegoryUseCase {

    @Autowired
    CathegoryRepository cathegoryRepository;

    @Override
    public Cathegory execute(Cathegory cathegory) {
        cathegoryRepository.save(cathegory);
        return cathegory;
    }
}
