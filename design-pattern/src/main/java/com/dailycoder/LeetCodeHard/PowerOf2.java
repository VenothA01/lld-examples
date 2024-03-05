package com.dailycoder.LeetCodeHard;

public class PowerOf2 {

    private int setBits;
    public int helper(int n,int setBits){

        if(n==0 || setBits>1)
            return setBits;

        // setBits += (n &1);
        if((n&1)==1){
            setBits++;
        }
//        System.out.println("n::"+n);
//        System.out.println("setBits::"+setBits);

        return helper(n>>1,setBits);
    }


    public boolean isPowerOfTwo(int n) {

//        Integer setBits = 0;
        helper(n,setBits);
        System.out.println("setBits::"+setBits);
        return setBits < 1 ? true : false;
    }

    public static void main(String[] args) {

        PowerOf2 T = new PowerOf2();
        System.out.println(T.isPowerOfTwo(3));
//        System.out.println(T.isPowerOfTwo(2));
//        System.out.println(T.isPowerOfTwo(16));
    }
}
