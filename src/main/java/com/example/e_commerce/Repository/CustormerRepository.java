package com.example.e_commerce.Repository;

import com.example.e_commerce.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustormerRepository extends JpaRepository<CustomerEntity, Integer> {


//    SELECT * FROM table_name WHERE columnname LIKE 'A%'


}
