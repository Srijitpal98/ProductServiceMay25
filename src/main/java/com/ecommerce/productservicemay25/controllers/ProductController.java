package com.ecommerce.productservicemay25.controllers;

import com.ecommerce.productservicemay25.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    public Product getSingleProduct(Long productId) {
        return null;
    }
}
