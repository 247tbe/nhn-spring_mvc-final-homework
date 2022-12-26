package com.nhnacademy.springmvc.exception;

import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

public class ValidationFailedException extends RuntimeException {
    public ValidationFailedException(BindingResult bindingResult) {
        super(bindingResult.getAllErrors()
                            .stream()
                            .map(error -> new StringBuilder().append("\nObjectName=").append(error.getObjectName())
                                .append(",\nMessage=").append(error.getDefaultMessage())
                                .append(",\ncode=").append(error.getCode()))
                            .collect(Collectors.joining(" | ")));
    }
}
