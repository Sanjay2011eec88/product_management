package com.productservices.products.service;

import com.productservices.products.dtos.ProductResponseDto;
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
    public Product getSingleProduct(Long Id) {
        RestTemplate restTemplate = new RestTemplate();
        //Takes in the API and the dto class and calls the url
        ProductResponseDto response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + Id,
                ProductResponseDto.class);

        return getProdcutFromResponseDTO(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDto[] products = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                ProductResponseDto[].class);
        List<Product> productList = new ArrayList<>();
        for (ProductResponseDto product : products) {
            productList.add(getProdcutFromResponseDTO(product));
        }
        return productList;
    }

    private Product getProdcutFromResponseDTO(ProductResponseDto response) {
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

