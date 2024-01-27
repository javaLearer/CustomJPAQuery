package com.db.joins.DBJoins.controller;


import com.db.joins.DBJoins.entity.Customer;
import com.db.joins.DBJoins.entity.Product;
import com.db.joins.DBJoins.exception.CustomException;
import com.db.joins.DBJoins.model.OrderProcess;
import com.db.joins.DBJoins.repo.CustRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustControoler {

    @Autowired
    private CustRepo custRepo;

    @PostMapping("/add")
   public void addProducts(@RequestBody Customer customer)
    {
         custRepo.save(customer);
    }

    @GetMapping("/viewAll")
    public List<Customer> viewAllCustProd()
    {

         List<Customer> customerList= custRepo.findAll();
        System.out.println("List size from DB : "+ customerList.size() );
        System.out.println("Printing list: "+ customerList.toString());
        return customerList;


    }

    @GetMapping("/getCustomer/{cid}")
    public Customer viewCust(@PathVariable int cid)
    {


             Customer customer=custRepo.findById(cid).
                     orElseThrow(()->new CustomException("No data found in DB for the id: "+ cid));
             System.out.println("Printing Customer details: "+ customer.toString());
           //  return new ResponseEntity<Customer>(customer, HttpStatus.OK);
             return customer;



    }
    // http://localhost:8080/customer/getCustProdName  - custom query in Repo class
    @GetMapping("/getCustProdName")
    public List<OrderProcess> getCustProdNameFromDb()
    {
        System.out.println("Get prod and customer name: "+ custRepo.getJoinInformation());
        return custRepo.getJoinInformation();
    }
}
