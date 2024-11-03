package com.productservices.products.service;

import com.productservices.products.dtos.ProductResponseDtoFs;
import com.productservices.products.exception.ProductNotPresentException;
import com.productservices.products.models.Category;
import com.productservices.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class FakestoreProductService implements IProductService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getSingleProduct(Long Id) throws ProductNotPresentException {
        if(Id > 20 && Id < 40){
            throw new ProductNotPresentException();
        }
        //Takes in the API and the dto class and calls the url
        ProductResponseDtoFs response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + Id,
                ProductResponseDtoFs.class);

        return getProdcutFromResponseDTO(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDtoFs[] products = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                ProductResponseDtoFs[].class);
        List<Product> productList = new ArrayList<>();
        for (ProductResponseDtoFs product : products) {
            productList.add(getProdcutFromResponseDTO(product));
        }
        return productList;
    }

    private Product getProdcutFromResponseDTO(ProductResponseDtoFs response) {
        Product product = new Product();
        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setPrice(response.getPrice());
        product.setDescription(response.getDescription());
        product.setImage(response.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(response.getCategory());
        return product;
    }
}

