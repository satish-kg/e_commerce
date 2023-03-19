package com.example.e_commerce.Repository;

import com.example.e_commerce.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = " select * from products where product_name like :='C%' ", nativeQuery = true)
    List<ProductEntity> getAllProductsByChar();
//    HashMap<String, Integer> getAllProductsByChar();
//    List<ProductEntity> getAllProductsByChar();
//    HashMap of ProductName & Price to be returned. Modify bill & CustomerService Layer accordingly.
}
