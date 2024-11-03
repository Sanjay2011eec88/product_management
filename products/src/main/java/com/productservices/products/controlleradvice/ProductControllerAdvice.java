package com.productservices.products.controlleradvice;

import com.productservices.products.dtos.ProductResponseSelf;
import com.productservices.products.exception.ProductNotPresentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotPresentException.class)
    public ResponseEntity<ProductResponseSelf> handleProductNotPresentException(ProductNotPresentException e){
        return new ResponseEntity<>(
                new ProductResponseSelf(null, "Product does not exist"),
                HttpStatus.NOT_FOUND);
    }
}
