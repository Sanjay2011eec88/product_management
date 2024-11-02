package com.productservices.products.controllers;

import com.productservices.products.dtos.ProductRequestDto;
import com.productservices.products.models.Category;
import com.productservices.products.models.Product;
import com.productservices.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public Product getProductDetails(@PathVariable Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products/categories/{id}")
    public List<Product> getAllProductsInCategories(@PathVariable Long id){
        return new ArrayList<Product>();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto requestDto){
        return new Product();
    }

    @PatchMapping("/products")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto requestDto){
        return new Product();
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }

}
