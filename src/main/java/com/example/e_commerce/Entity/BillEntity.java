package com.example.e_commerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
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

    public BillEntity(String userName, String userEmail, List<Integer>prodId, List<String>prodName, List<Integer>prodCount, List<Integer>prodPrice, List<Integer>prodCost, int total){
        prodId = new ArrayList<Integer>();
        prodName = new ArrayList<String>();
        prodCount = new ArrayList<Integer>();
        prodPrice = new ArrayList<Integer>();
        prodCost = new ArrayList<Integer>();

        this.customerNameForBill = userName;
        this.customerEmailForBill = userEmail;
        this.productIdForBill = prodId;
        this.productNameForBill = prodName;
        this.productCountForBill = prodCount;
        this.productPriceForBill = prodPrice;
        this.productCostForBill = prodCost;
        this.totalCost = total;
    }

    public BillEntity(){

    }

    @OneToOne
    @JoinColumn
    private OrderEntity orderEntityForBill;

}
