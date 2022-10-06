package com.winvents.products.application.infrastructure.controller;

import com.winvents.products.application.domain.Cathegory;
import com.winvents.products.application.infrastructure.dto.ProductDto;
import com.winvents.products.application.usecase.cathegory.create.CreateCathegoryUseCase;
import com.winvents.products.application.usecase.cathegory.list.ListCathegoriesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CathegoryController {

    private final CreateCathegoryUseCase createCathegoryUseCase;

    private final ListCathegoriesUseCase listCathegoriesUseCase;

    @GetMapping
    public ResponseEntity<List<Cathegory>> listProducts() {
        List<Cathegory> cathegories = listCathegoriesUseCase.execute();
        if (cathegories == null || cathegories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cathegories, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cathegory> createCathegory(@RequestBody @Valid Cathegory form) {
        Cathegory cathegory = createCathegoryUseCase.execute(form);
        return new ResponseEntity<>(cathegory, HttpStatus.CREATED);
    }

}
