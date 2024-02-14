package com.dailycoder.creational;

interface Shape{

    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing Rectangle");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing Square");
    }

}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing Circle");
    }

}

public class Factory {

    public static Shape getShapeInstance(String a) {

        if(a.equals("Circle"))
            return  new Circle();

        if(a.equals("Square"))
            return new Square();

        if(a.equals("Rectangle"))
            return new Rectangle();

        return null;
    }

    public static void main(String[] args) {

        Factory.getShapeInstance("Circle").draw();
    }

}
