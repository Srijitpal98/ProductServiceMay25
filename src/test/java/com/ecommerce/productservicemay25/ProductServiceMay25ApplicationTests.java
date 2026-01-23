package com.ecommerce.productservicemay25;

import com.ecommerce.productservicemay25.models.Category;
import com.ecommerce.productservicemay25.models.Product;
import com.ecommerce.productservicemay25.repositories.CategoryRepository;
import com.ecommerce.productservicemay25.repositories.ProductRepository;
import com.ecommerce.productservicemay25.services.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceMay25ApplicationTests {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

//	public ProductServiceMay25ApplicationTests(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}

	@Test
	void contextLoads() {
	}

	@Test
//	@Transactional
	void testQuery() {
		//EAGER
//		Optional<Product> productOptional = productRepository.findById(3L);

		//LAZY
//		Optional<Category> categoryOptional = categoryRepository.findById(2L);

//		System.out.println("DEBUG");
//
//		List<Product> products = categoryOptional.get().getProducts();
//		//select * from products where category_id = 2L;
//
//		System.out.println(products.get(0).getTitle());
//
//		System.out.println("DEBUG");

//		System.out.println("DEBUG-1");
//
//		Product product = productRepository.findProductWithGivenId(1L);
//
//		System.out.println("DEBUG-2");
	}
}
