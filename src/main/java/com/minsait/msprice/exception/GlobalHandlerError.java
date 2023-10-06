package com.minsait.msprice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.minsait.openapi.model.ErrorDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalHandlerError extends ResponseEntityExceptionHandler {

    private static final ErrorDTO errorDto = new ErrorDTO();

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException e) {
        log.error("Price not found for given parameters");
        createGlobalHandlerErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException e) {
        log.error("Product not found for given parameters");
        createGlobalHandlerErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<Object> handleBrandNotFoundException(BrandNotFoundException e) {
        log.error("Brand not found for given parameters");
        createGlobalHandlerErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    private static void createGlobalHandlerErrorResponse(int code, String message) {
        errorDto.setCode(code);
        errorDto.setMessage(message);
    }
}
