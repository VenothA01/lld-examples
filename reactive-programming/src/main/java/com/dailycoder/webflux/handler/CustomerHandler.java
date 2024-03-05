package com.dailycoder.webflux.handler;


import com.dailycoder.webflux.dao.CustomerDao;
import com.dailycoder.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao customerDao;


    public Mono<ServerResponse> loadCustomer(ServerRequest serverRequest){
        var customerList = customerDao.streamAllCustomersList();
        return ServerResponse.ok().body(customerList, Customer.class);
    }

    public Mono<ServerResponse> findCustiomerById(ServerRequest serverRequest){
        int id =  Integer.valueOf(serverRequest.pathVariable("id"));
        Mono<Customer> customerMono = customerDao.streamAllCustomers().filter(c->c.id()==id).next();
        return ServerResponse.ok().body(customerMono,Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest serverRequest){
      var payload =  serverRequest.bodyToMono(Customer.class);
      var res = payload.map(dto -> dto.id()+" "+dto.name());
      return ServerResponse.ok().body(res,String.class);
    }
}

