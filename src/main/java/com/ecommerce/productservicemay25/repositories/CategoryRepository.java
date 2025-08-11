package com.ecommerce.productservicemay25.repositories;

import com.ecommerce.productservicemay25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String name);
}
