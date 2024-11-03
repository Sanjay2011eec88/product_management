package com.productservices.products.controllers;

import com.productservices.products.dtos.ProductRequestDtoFs;
import com.productservices.products.dtos.ProductResponseSelf;
import com.productservices.products.exception.ProductNotPresentException;
import com.productservices.products.models.Product;
import com.productservices.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseSelf   > getProductDetails(@PathVariable Long id) throws ProductNotPresentException {
        Product product;
        product = productService.getSingleProduct(id);

        return new ResponseEntity<>(
                new ProductResponseSelf(product, "success"),
                HttpStatus.OK);
    }



    @GetMapping("/products/categories/{id}")
    public List<Product> getAllProductsInCategories(@PathVariable Long id){
        return new ArrayList<Product>();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDtoFs requestDto){
        return new Product();
    }

    @PatchMapping("/products")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDtoFs requestDto){
        return new Product();
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }

}
