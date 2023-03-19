package com.example.e_commerce.Service;

import com.example.e_commerce.Convertor.ConvertToCustomerEntity;
import com.example.e_commerce.DTO.CustomerRequestDTO;
import com.example.e_commerce.Entity.CustomerEntity;
import com.example.e_commerce.Entity.OrderEntity;
import com.example.e_commerce.Repository.CustormerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustormerRepository custormerRepository;

    public String addCustomer(CustomerRequestDTO customerRequestDTO){

        try{
            CustomerEntity customerEntity = ConvertToCustomerEntity.convertToCustomerEntity(customerRequestDTO);
            custormerRepository.save(customerEntity);
            return "Customer data saved.";
        }catch (Exception e){
            return "Bad Request "+'"'+e.getMessage()+'"'+" !!";
        }

    }

    public String allOrder(char c, int customerId){
        CustomerEntity customerEntity = custormerRepository.findById(customerId).get();
        List<OrderEntity> orderListForCustomer = customerEntity.getOrderListForCustomer();
//        OrderEntity orderEntity =
        return "everything ordered successfully.";
    }

//    public String addToCart(int prodId){
//
//
//        return "product successfully added to the cart!";
//    }

}
