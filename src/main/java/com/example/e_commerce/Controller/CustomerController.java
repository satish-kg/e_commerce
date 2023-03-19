package com.example.e_commerce.Controller;

import com.example.e_commerce.DTO.CustomerRequestDTO;
import com.example.e_commerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    @RequestMapping("/addCustomer")
    public ResponseEntity<String> addCustomer (@RequestBody CustomerRequestDTO customerRequestDTO){
        try{
            String result = customerService.addCustomer(customerRequestDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @RequestMapping("/allOrder")
    public ResponseEntity<String> allOrder(char c, int customerId){
        try{
            String result = customerService.allOrder(c, customerId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

//    @RequestMapping("/addToCart")
//    public String addToCart(@RequestParam("prodId") Integer prodId){
//        String result = customerService.addToCart(prodId);
//        return result;
//    }


}
