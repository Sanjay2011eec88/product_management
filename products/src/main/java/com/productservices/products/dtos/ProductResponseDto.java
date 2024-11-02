package com.productservices.products.dtos;

import com.productservices.products.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private float price;
    private String description;
    private String image;
    private String category;
}
