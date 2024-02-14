package com.dailycoder.creational;

class Dist{

    private static Dist dist;

    private Dist(){

    }

    public static Dist getInstance(){
        if(dist==null)
            dist = new Dist();

        return dist;
    }

}

public class SingleTon {




    public static void main(String[] args) {

        Dist dist = Dist.getInstance();
        Dist dist1 = Dist.getInstance();
        System.out.println(dist1==dist);

    }
}
