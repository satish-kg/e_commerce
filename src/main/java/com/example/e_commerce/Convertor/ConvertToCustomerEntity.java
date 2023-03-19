package com.example.e_commerce.Convertor;

import com.example.e_commerce.DTO.CustomerRequestDTO;
import com.example.e_commerce.Entity.CustomerEntity;

public class ConvertToCustomerEntity {

    public static CustomerEntity convertToCustomerEntity(CustomerRequestDTO customerRequestDTO){
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customerRequestDTO.getName())
                .email(customerRequestDTO.getEmail())
                .mobileNo(customerRequestDTO.getMobileNo())
                .password(customerRequestDTO.getPassword())
                .build();
        return customerEntity;
    }
}
