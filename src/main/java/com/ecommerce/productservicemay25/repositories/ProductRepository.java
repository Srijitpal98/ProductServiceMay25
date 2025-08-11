package com.ecommerce.productservicemay25.repositories;

import com.ecommerce.productservicemay25.models.Category;
import com.ecommerce.productservicemay25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //select * from Product where id = ?
    @Override
    Optional<Product> findById(Long productId);

    //select * from products where lower(title) LIKE %iphone%
    List<Product> findByTitleContainsIgnoreCase(String title);

    //find all the products where price >= 100 and <= 1000
    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    //search a product of a particular category
    //select * from products where category_id = category.id;
    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Id(Long categoryId);

    /*
    Select * from Products P
    JOIN Category C
    on p.category_id = c.category_id
    where c.category_title like 'categoryTitle';
     */
    List<Product> findAllByCategory_Title(String categoryTitle);

//    @Query("select title from products where id = ?")
//    Optional<Product> findOnlyProductTitleById(Long productId);

    Product save(Product product);
    //update + insert => upsert


    @Override
    void deleteById(Long productId);
}


//public interface UserRepository extends JpaRepository<User, Long> {
//
//    List<User> findByLastname(String lastname);
//
//    User findByEmailAddress(String emailAddress);
//}