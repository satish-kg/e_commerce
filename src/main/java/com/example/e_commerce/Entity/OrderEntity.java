package com.example.e_commerce.Entity;

import com.example.e_commerce.Enum.PaymentMode;
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
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private PaymentMode paymentMode;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<ProductEntity> productListForAnOrder;

    @ManyToOne
    @JoinColumn
    private CustomerEntity customer;

    @OneToOne(mappedBy = "orderEntityForBill", cascade = CascadeType.ALL)
    private BillEntity billEntity;

}
