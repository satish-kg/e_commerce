package com.example.e_commerce.Service;

import com.example.e_commerce.Entity.CustomerEntity;
import com.example.e_commerce.Entity.OrderEntity;
import com.example.e_commerce.Entity.ProductEntity;
import com.example.e_commerce.Enum.PaymentMode;
import com.example.e_commerce.Repository.CustormerRepository;
import com.example.e_commerce.Repository.OrderRepository;
import com.example.e_commerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustormerRepository custormerRepository;

    public String addOrder(List<Integer> prodIdList, PaymentMode paymentMode, int customerId){
        OrderEntity orderEntity = new OrderEntity();
        List<ProductEntity> order = new ArrayList<>();

        for(int x : prodIdList){
            order.add(productRepository.findById(x).get());
        }

        orderEntity.setProductListForAnOrder(order);
        CustomerEntity customer = custormerRepository.findById(customerId).get();
        orderEntity.setCustomer(customer);
        orderEntity.setPaymentMode(paymentMode);

        List<OrderEntity> orderEntityListOfCustomer = customer.getOrderListForCustomer();
        orderEntityListOfCustomer.add(orderEntity);

        custormerRepository.save(customer);
        orderRepository.save(orderEntity);

        return "Order added successfully!!";
    }

}
