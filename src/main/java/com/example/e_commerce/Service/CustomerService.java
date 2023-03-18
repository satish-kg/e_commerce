package com.example.e_commerce.Service;

import com.example.e_commerce.Repository.CustormerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustormerRepository custormerRepository;

}
