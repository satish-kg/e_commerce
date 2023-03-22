package com.example.e_commerce.Controller;

import com.example.e_commerce.DTO.CustomerRequestDTO;
import com.example.e_commerce.Entity.BillEntity;
import com.example.e_commerce.Enum.Classification;
import com.example.e_commerce.Enum.PaymentMode;
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

    @GetMapping
    @RequestMapping("/allOrder")
    public BillEntity allOrder(@RequestParam("customerId") Integer customerId, @RequestParam("paymentMode")PaymentMode paymentMode){
        try{
            BillEntity bill = customerService.allOrder(customerId, paymentMode);
            return bill;
//            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            BillEntity billError = new BillEntity();
            billError.setCustomerNameForBill("ERROR");
            billError.setCustomerEmailForBill("ERROR");
            return billError;
        }
    }

    @GetMapping
    @RequestMapping("/getMaxPriceForClassification")
    public int  getMaxPriceForClassification(@RequestParam("classification") int classification){
        try{
            int result = customerService.getMaxPriceForClassification(classification);
            return result;
        }catch (Exception e){
            System.out.println("ERRORRRRRR : "+e.getMessage());
            return -1;
        }
    }


//    @RequestMapping("/addToCart")
//    public String addToCart(@RequestParam("prodId") Integer prodId){
//        String result = customerService.addToCart(prodId);
//        return result;
//    }


}
