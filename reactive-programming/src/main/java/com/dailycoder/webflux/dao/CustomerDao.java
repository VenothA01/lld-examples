package com.dailycoder.webflux.dao;

import com.dailycoder.webflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepInSeconds(int i){

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){

        }
    }
    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1,50)
                .peek(CustomerDao::sleepInSeconds)
                .peek(i->System.out.println("processing count "+i))
                .mapToObj(i->new Customer(i,"Customer "+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> streamAllCustomers(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("processing count "+i))
                .map(i->new Customer(i,"Customer "+i));
    }

    public Flux<Customer> streamAllCustomersList(){
        return Flux.range(1,10)
                .doOnNext(i->System.out.println("processing count "+i))
                .map(i->new Customer(i,"Customer "+i));
    }
}
