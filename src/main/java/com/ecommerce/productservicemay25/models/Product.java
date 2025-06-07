package com.ecommerce.productservicemay25.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private Double price;
    private String description;
    private String image;
    private Category category;
}
