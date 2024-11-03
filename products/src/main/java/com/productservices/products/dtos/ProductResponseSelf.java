package com.productservices.products.dtos;

import com.productservices.products.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseSelf {
    private Product product;
    private String message;
}
