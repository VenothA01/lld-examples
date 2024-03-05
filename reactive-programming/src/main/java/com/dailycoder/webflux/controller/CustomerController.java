package com.dailycoder.webflux.controller;

import com.dailycoder.webflux.dto.Customer;
import com.dailycoder.webflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.loadAllCustomers();
    }

    @GetMapping(value = "/stream")
    public Flux<Customer> getStreamAllCustomers(){
        return service.streamAllCustomers();
    }

}
