package com.dailycoder.webflux.handler;

import com.dailycoder.webflux.dao.CustomerDao;
import com.dailycoder.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class CustomerSteramHandler {

    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> streamCustomer(ServerRequest serverRequest){
        var customerList = customerDao.streamAllCustomers();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerList, Customer.class);
    }
}
