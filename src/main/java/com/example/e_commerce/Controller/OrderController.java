package com.example.e_commerce.Controller;

import com.example.e_commerce.Entity.ProductEntity;
import com.example.e_commerce.Enum.PaymentMode;
import com.example.e_commerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

//    @PostMapping("/addOrder")
//    public ResponseEntity<String> addOrder(List<Integer>prodIdList, PaymentMode paymentMode, int customerId){
//        try{
//            String result = orderService.addOrder(prodIdList, paymentMode, customerId);
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

}
