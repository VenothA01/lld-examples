package com.dailycoder;

public class Person {

    private String name;
    private int age;

    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        throw  new UnsupportedOperationException("Person object is immutable");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        throw  new UnsupportedOperationException("Person object is immutable");
    }
}
