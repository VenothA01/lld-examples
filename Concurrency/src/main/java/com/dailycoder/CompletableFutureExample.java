package com.dailycoder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureExample {


    public static void main(String[] args) {

        Supplier<String> supplier = () -> {

            if(Math.random()<0.5){
                throw new RuntimeException("Random value less than 5");
            }
            return "Success";
        };

        CompletableFuture<String> future = CompletableFuture.supplyAsync(supplier).exceptionally(throwable -> throwable.getMessage());

        future.thenAccept(System.out::println);
        System.out.println("Done");



    }
}
