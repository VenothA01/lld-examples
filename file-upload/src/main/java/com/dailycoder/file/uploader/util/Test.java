package com.dailycoder.file.uploader.util;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void monotonicStack(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int N = arr.length;
        for(int i=0;i<N;++i){
            while (!stack.isEmpty() && stack.peek()>arr[i]){
                stack.pop();
            }
            stack.push(arr[i]);
        }

        System.out.println(stack);
    }

    public static void main(String[] args) {

        int[] arr = { 1, 4, 5, 3, 12, 10 };
        monotonicStack(arr);



    }


}
