package com.example.e_commerce.Service;

import com.example.e_commerce.Convertor.ConvertToCustomerEntity;
import com.example.e_commerce.DTO.CustomerRequestDTO;
import com.example.e_commerce.Entity.BillEntity;
import com.example.e_commerce.Entity.CustomerEntity;
import com.example.e_commerce.Entity.OrderEntity;
import com.example.e_commerce.Entity.ProductEntity;
import com.example.e_commerce.Repository.CustormerRepository;
import com.example.e_commerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustormerRepository custormerRepository;

    @Autowired
    ProductRepository productRepository;

    public String addCustomer(CustomerRequestDTO customerRequestDTO){

        try{
            CustomerEntity customerEntity = ConvertToCustomerEntity.convertToCustomerEntity(customerRequestDTO);
            custormerRepository.save(customerEntity);
            return "Customer data saved.";
        }catch (Exception e){
            return "Bad Request "+'"'+e.getMessage()+'"'+" !!";
        }

    }

    public BillEntity allOrder(int customerId){
        CustomerEntity customerEntity = custormerRepository.findById(customerId).get();

        List<OrderEntity> orderListForCustomer = customerEntity.getOrderListForCustomer();

        List<ProductEntity> productListForOrder = productRepository.getAllProductsByChar();

        BillEntity billEntity = new BillEntity();

        billEntity.setCustomerNameForBill(customerEntity.getName());
        billEntity.setCustomerEmailForBill(customerEntity.getEmail());

        List<Integer> prodIdForBillEntity = billEntity.getProductIdForBill();
        List<String> prodNameForBillEntity = billEntity.getProductNameForBill();
        List<Integer> prodCountForBillEntity = billEntity.getProductCountForBill();
        List<Integer> prodPriceForBillEntity = billEntity.getProductPriceForBill();
        List<Integer> prodCostForBillEntity = billEntity.getProductCostForBill();

        int totalCost = billEntity.getTotalCost();

        for(ProductEntity product : productListForOrder){
            prodIdForBillEntity.add(product.getProductId());
            prodNameForBillEntity.add(product.getProductName());
            prodCountForBillEntity.add(1);
            prodPriceForBillEntity.add(product.getPrice());
            prodCostForBillEntity.add(product.getPrice());
            totalCost += product.getPrice();
        }

        billEntity.setProductIdForBill(prodIdForBillEntity);
        billEntity.setProductNameForBill(prodNameForBillEntity);
        billEntity.setProductCountForBill(prodCountForBillEntity);
        billEntity.setProductPriceForBill(prodPriceForBillEntity);
        billEntity.setProductCostForBill(prodCostForBillEntity);
        billEntity.setTotalCost(totalCost);
//        OrderEntity orderEntity =
        return billEntity;
    }

    /*
        private String customerNameForBill;
        private String customerEmailForBill;
        private List<Integer> productIdForBill;
        private List<String> productNameForBill;
        private List<Integer> productCountForBill;
        private List<Integer> productPriceForBill;
        private List<Integer> productCostForBill;
        private int totalCost;
         */

//    public String addToCart(int prodId){
//
//
//        return "product successfully added to the cart!";
//    }

}
