package com.dailycoder.webflux.service;

import java.util.List;

import com.dailycoder.webflux.dao.CustomerDao;
import com.dailycoder.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers(){

        long start = System.currentTimeMillis();
        var customers =  customerDao.getCustomers();
        long totalTime = System.currentTimeMillis() - start ;
        System.out.println("toal time processed ::"+totalTime);
        return customers;
    }

    public Flux<Customer> streamAllCustomers(){

        long start = System.currentTimeMillis();
        var customers =  customerDao.streamAllCustomers();
        long totalTime = System.currentTimeMillis() - start ;
        System.out.println("toal time processed ::"+totalTime);
        return customers;
    }
}
