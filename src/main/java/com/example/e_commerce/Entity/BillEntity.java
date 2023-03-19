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
@Table(name = "bills")
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    private String customerNameForBill;
    private String customerEmailForBill;
    private List<Integer> productIdForBill;
    private List<String> productNameForBill;
    private List<Integer> productCountForBill;
    private List<Integer> productPriceForBill;
    private List<Integer> productCostForBill;
    private int totalCost;

    @OneToOne
    @JoinColumn
    private OrderEntity orderEntityForBill;

}
