package com.dailycoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public static void delay(int min) throws InterruptedException {
        TimeUnit.MINUTES.wait(min);
    }

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<List<Integer>> f = service.submit(ExecutorServiceExample::call);

    }

    private static List<Integer> call() {
        try {
            System.out.println("Thread :" + Thread.currentThread().getName());
            delay(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Arrays.asList(1, 2, 3, 4);
    }
}
