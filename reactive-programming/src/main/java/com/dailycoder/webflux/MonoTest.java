package com.dailycoder.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class MonoTest {


    @Test
    public void testMono(){
      var res =  Mono.just("dailycoder")
              .then(Mono.error(new RuntimeException("exception occurred")))
              .log();
      res.subscribe(System.out::println,e->System.out.println(e.getMessage()));
    }

    @Test
    public void TestFlux(){
       var fluxString = Flux.just("Spring","SpringBoot","Hibernate")
                       .concatWithValues("AWS","GCP")
                       .concatWith(Flux.error(new RuntimeException("new Exception occurred in flux")))
                               .concatWithValues("Azure");
       fluxString.subscribe(System.out::println);
    }


}
