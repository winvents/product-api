package com.winvents.products.application.usecase.cathegory.list;

import com.winvents.products.application.domain.Cathegory;
import com.winvents.products.application.infrastructure.repository.CathegoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCathegoriesUseCaseImpl implements ListCathegoriesUseCase {

    @Autowired
    private CathegoryRepository cathegoryRepository;

    @Override
    public List<Cathegory> execute() {

        List<Cathegory> cathegories = cathegoryRepository.findAll();
        return cathegories;

    }
}
