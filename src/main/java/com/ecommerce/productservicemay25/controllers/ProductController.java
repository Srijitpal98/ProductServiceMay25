package com.ecommerce.productservicemay25.controllers;

import com.ecommerce.productservicemay25.dtos.ExceptionDto;
import com.ecommerce.productservicemay25.exceptions.ProductNotFoundException;
import com.ecommerce.productservicemay25.models.Product;
import com.ecommerce.productservicemay25.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final RestTemplate restTemplate;
    private ProductService productService;

    public ProductController(@Qualifier("${variable}") ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    // localhost:8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        // Should we call FakeStore API here? No, we should make a call to the Service

        //throw new RuntimeException("Something went wrong");
        ResponseEntity<Product> responseEntity =
                new ResponseEntity<>(
                        productService.getSingleProduct(productId),
                        HttpStatus.OK
                );
//        Product product = null;
//        try {
//            product = productService.getSingleProduct(productId);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return responseEntity;
    }

    // localhost:8080/products/
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
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

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Handling Exception within the Controller");
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
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