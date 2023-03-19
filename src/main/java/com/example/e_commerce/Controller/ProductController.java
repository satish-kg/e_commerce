package com.example.e_commerce.Controller;

import com.example.e_commerce.DTO.ProductRequestDTO;
import com.example.e_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/addToCart")
    public String addToCart(@RequestParam("prodId") Integer prodId){
        String result = productService.addToCart(prodId);
        return result;
    }

    @RequestMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        try{
            String result = productService.addProduct(productRequestDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
