package com.example.e_commerce.DTO;

import com.example.e_commerce.Enum.Classification;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ProductRequestDTO {
    private String productDTOname;
    private int productDTOprice;
    private Classification productDTOclassification;

}
