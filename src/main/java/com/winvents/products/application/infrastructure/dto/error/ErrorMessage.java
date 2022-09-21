package com.winvents.products.application.infrastructure.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String path;
    private String message;

}
