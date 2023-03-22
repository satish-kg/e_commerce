package com.example.e_commerce.Service;

import com.example.e_commerce.Convertor.ConvertToCustomerEntity;
import com.example.e_commerce.DTO.CustomerRequestDTO;
import com.example.e_commerce.Entity.BillEntity;
import com.example.e_commerce.Entity.CustomerEntity;
import com.example.e_commerce.Entity.OrderEntity;
import com.example.e_commerce.Entity.ProductEntity;
import com.example.e_commerce.Enum.PaymentMode;
import com.example.e_commerce.Repository.CustormerRepository;
import com.example.e_commerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public BillEntity allOrder(Integer customerId, PaymentMode paymentMode){

        CustomerEntity customerEntity = custormerRepository.findById(customerId).get();

        List<OrderEntity> orderListForCustomer = customerEntity.getOrderListForCustomer();

        List<Integer> productIdListForOrder = productRepository.getAllProductsByChar();

        List<ProductEntity> productListForOrder = new ArrayList<>();

        for(int x : productIdListForOrder){
            ProductEntity prod = productRepository.findById(x).get();
            productListForOrder.add(prod);
        }


        BillEntity billEntity = new BillEntity();

        billEntity.setCustomerNameForBill(customerEntity.getName());
        billEntity.setCustomerEmailForBill(customerEntity.getEmail());

        List<Integer> prodIdForBillEntity = billEntity.getProductIdForBill();
        List<String> prodNameForBillEntity = billEntity.getProductNameForBill();

        List<Integer> prodCountForBillEntity = billEntity.getProductCountForBill();
        if(prodCountForBillEntity == null) System.out.println("ERROR FOUNDDDDDDDDDDDDDDDDD");
        List<Integer> prodPriceForBillEntity = billEntity.getProductPriceForBill();
        List<Integer> prodCostForBillEntity = billEntity.getProductCostForBill();

        int totalCost = billEntity.getTotalCost();
//        System.out.println("Line 67.555555555555555555555555555555555");
        for(ProductEntity product : productListForOrder){
            System.out.println("PRODUCTTTTTTTTTTTTTTTTTTTTTTTTT : "+product.getPrice());
            prodIdForBillEntity.add(product.getProductId());
            prodNameForBillEntity.add(product.getProductName());
            prodCountForBillEntity.add(1);
            System.out.println("1 appended successssssssssssssssssssssssss");
            prodPriceForBillEntity.add(product.getPrice());
            prodCostForBillEntity.add(product.getPrice());
            totalCost += product.getPrice();
        }
        System.out.println("Line 76.555555555555555555555555555555555");
        billEntity.setProductIdForBill(prodIdForBillEntity);
        billEntity.setProductNameForBill(prodNameForBillEntity);
        billEntity.setProductCountForBill(prodCountForBillEntity);
        billEntity.setProductPriceForBill(prodPriceForBillEntity);
        billEntity.setProductCostForBill(prodCostForBillEntity);
        billEntity.setTotalCost(totalCost);

//        System.out.println("Line 84.555555555555555555555555555555555");
//        OrderEntity orderEntity =

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomer(customerEntity);
        orderEntity.setBillEntity(billEntity);
        orderEntity.setPaymentMode(paymentMode);

        orderListForCustomer.add(orderEntity);
        customerEntity.setOrderListForCustomer(orderListForCustomer);

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
