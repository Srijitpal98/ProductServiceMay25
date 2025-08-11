package com.ecommerce.productservicemay25.services;

import com.ecommerce.productservicemay25.exceptions.CategoryNotFoundException;
import com.ecommerce.productservicemay25.exceptions.ProductNotFoundException;
import com.ecommerce.productservicemay25.models.Category;
import com.ecommerce.productservicemay25.models.Product;
import com.ecommerce.productservicemay25.repositories.CategoryRepository;
import com.ecommerce.productservicemay25.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);

//        if (optionalProduct.isEmpty()) {
//            throw new ProductNotFoundException("Product with id " + productId + " doesn't exists.");
//        }
//
//        return optionalProduct.get();

        return optionalProduct
                .orElseThrow(
                        () -> new ProductNotFoundException(productId, "Product with id " + productId + " doesn't exists."));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException{
        Category category = product.getCategory();

        if(category == null) {
            throw new CategoryNotFoundException("Product can't be created without " +
                    "category information. Please try again with Category.");
        }

        //Find the category using the title.
        Optional<Category> categoryOptional = categoryRepository.findByTitle(category.getTitle());

        if(categoryOptional.isEmpty()) {
            //There's no category in the DB with the given title.
            //Create a category object and save it in the DB
            category = categoryRepository.save(category);
        }
        else {
            category = categoryOptional.get();
        }
        product.setCategory(category);
        return productRepository.save(product);
//        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
