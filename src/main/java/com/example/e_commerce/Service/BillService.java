package com.example.e_commerce.Service;

import com.example.e_commerce.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;
}
