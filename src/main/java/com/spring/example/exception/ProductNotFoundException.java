package com.spring.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
