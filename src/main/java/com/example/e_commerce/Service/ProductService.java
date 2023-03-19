package com.example.e_commerce.Service;

import com.example.e_commerce.Convertor.ProductDTOtoEntityConvertor;
import com.example.e_commerce.DTO.ProductRequestDTO;
import com.example.e_commerce.Entity.ProductEntity;
import com.example.e_commerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String addToCart(int prodId){

        return "product successfully added to the cart!";
    }

    public String addProduct(ProductRequestDTO productRequestDTO){
        ProductEntity productEntity = ProductDTOtoEntityConvertor.productDTOtoEntityConvertor(productRequestDTO);
        productRepository.save(productEntity);
//        productRepository.save();
        return "Product added successfully.";
    }

}
