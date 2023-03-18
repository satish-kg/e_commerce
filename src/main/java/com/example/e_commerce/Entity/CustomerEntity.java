package com.example.e_commerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;
    private String password;
    private String email;
    private String mobileNo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> orderListForCustomer;
}
