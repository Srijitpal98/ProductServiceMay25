package com.ecommerce.productservicemay25;

import com.ecommerce.productservicemay25.models.Product;
import com.ecommerce.productservicemay25.repositories.ProductRepository;
import com.ecommerce.productservicemay25.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceMay25ApplicationTests {
	@Autowired
	private ProductRepository productRepository;

//	public ProductServiceMay25ApplicationTests(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}

	@Test
	void contextLoads() {
	}

//	@Test
//	void testQuery() {
//		Optional<Product> productOptional = productRepository.findById(1L);
//
//		System.out.println("DEBUG-1");
//
//		Product product = productRepository.findProductWithGivenId(1L);
//
//		System.out.println("DEBUG-2");
//	}
}
