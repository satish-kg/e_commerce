package com.example.e_commerce.Entity;

import com.example.e_commerce.Enum.Classification;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int price;
    @Enumerated(EnumType.STRING)
    private Classification classification;

//    @OneToMany
//    @JoinColumn
//    private OrderEntity order;
}
