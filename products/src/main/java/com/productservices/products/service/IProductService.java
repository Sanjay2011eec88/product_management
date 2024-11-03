package com.productservices.products.service;

import com.productservices.products.exception.ProductNotPresentException;
import com.productservices.products.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    Product getSingleProduct(Long Id) throws ProductNotPresentException;

    List<Product> getAllProducts();
}
