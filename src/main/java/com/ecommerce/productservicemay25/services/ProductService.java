package com.ecommerce.productservicemay25.services;

import com.ecommerce.productservicemay25.exceptions.CategoryNotFoundException;
import com.ecommerce.productservicemay25.exceptions.ProductNotFoundException;
import com.ecommerce.productservicemay25.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product) throws CategoryNotFoundException;

    void deleteProduct(Long productId);
    
}
