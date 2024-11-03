package com.productservices.products.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDtoFs {
    private Long id;
    private String title;
    private float price;
    private String description;
    private String image;
    private String category;
}
