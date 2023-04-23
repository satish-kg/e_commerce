package com.example.e_commerce.Repository;

import com.example.e_commerce.Entity.ProductEntity;
import com.example.e_commerce.Enum.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

//    ProductEntity

    @Query(value = " select product_id from products where product_name like 'C%' ", nativeQuery = true)
    List<Integer> getAllProductsByChar();

    @Query(value = "select max(price) from products where classification := classificationPassed ",nativeQuery = true)
    int getMaxPriceForClassification(Classification classificationPassed);
//    HashMap<String, Integer> getAllProductsByChar();
//    List<ProductEntity> getAllProductsByChar();
//    HashMap of ProductName & Price to be returned. Modify bill & CustomerService Layer accordingly.
}
