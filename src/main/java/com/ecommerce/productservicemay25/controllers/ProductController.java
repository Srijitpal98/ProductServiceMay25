package com.ecommerce.productservicemay25.controllers;

import com.ecommerce.productservicemay25.models.Product;
import com.ecommerce.productservicemay25.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) {
        // Should we call FakeStore API here?
        // No, we should make a call to the Service
        return productService.getSingleProduct(productId);
    }

    // localhost:8080/products/
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    // localhost:8080/products/
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        return null;
    }

//    @PatchMapping("/{id}")
//    public Product updateProduct(@PathVariable("id") Product product) {
//        return product;
//    }
//
//    @PutMapping("/{id}")
//    public Product replaceProduct(@PathVariable("id") Product product) {
//        return product;
//    }

}

/*

   CRUD operations on Product module
 */
/* JSON object
    {
        "title" : "iPhone 15 pro",
        "description" : "best iphone ever",
        "price" : "130000"
        ....
    }
 */