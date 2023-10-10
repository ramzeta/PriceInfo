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

    @ExceptionHandler(PriceException.class)
    public ResponseEntity<Object> handlePriceException(PriceException e) {
        log.error("Price not found for given parameters");
        createGlobalHandlerErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Object> handleProductException(ProductException e) {
        log.error("Product not found for given parameters");
        createGlobalHandlerErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BrandException.class)
    public ResponseEntity<Object> handleBrandNotFoundException(BrandException e) {
        log.error("Brand not found for given parameters");
        createGlobalHandlerErrorResponse(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    private static void createGlobalHandlerErrorResponse(int code, String message) {
        errorDto.setCode(code);
        errorDto.setMessage(message);
    }
}
