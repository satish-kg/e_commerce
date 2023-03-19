package com.example.e_commerce.Convertor;

import com.example.e_commerce.DTO.ProductRequestDTO;
import com.example.e_commerce.Entity.ProductEntity;

public class ProductDTOtoEntityConvertor {

    public static ProductEntity productDTOtoEntityConvertor(ProductRequestDTO productRequestDTO){
        ProductEntity productEntity = ProductEntity.builder()
                .productName(productRequestDTO.getProductDTOname())
                .price(productRequestDTO.getProductDTOprice())
                .classification(productRequestDTO.getProductDTOclassification())
                .build();
        return productEntity;
    }
}
