package com.example.e_commerce.Repository;

import com.example.e_commerce.Entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Integer> {
}
