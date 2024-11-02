package com.productservices.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends  BaseModel {
    private String description;
    private String image;
    private float price;
    private String name;

    @ManyToOne
    private Category category;
}
