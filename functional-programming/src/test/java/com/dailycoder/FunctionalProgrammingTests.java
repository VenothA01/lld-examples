package com.dailycoder;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalProgrammingTests {

    private Optional<Integer> parseInt(String s){
        Integer result = null;
        try{
            result = Integer.parseInt(s);
        }
        finally {
             return Optional.ofNullable(result);
        }
    }

    @Test
    public void useofLambda(){
        SquareCalc calc = num -> num * num;

        assertEquals(calc.square(1),1);
        assertEquals(calc.square(2),4);
        assertEquals(calc.square(3),9);
        assertEquals(calc.square(4),16);
        assertEquals(calc.square(5),25);
        Integer.parseInt("");
    }




    @Test
    public void testUseOfStreams(){

        List<Integer> list  = IntStream.rangeClosed(0,10).boxed().toList();
        List<Integer> evenList = list.stream().filter(num -> (num & 1)!=1).collect(Collectors.toList());
        System.out.println(evenList);
    }

    @Test
    public void testUseOfOptional(){
        assertEquals(5,parseInt("5").get());
        assertEquals(0,parseInt("0").get());
        assertEquals(-1,parseInt("-1").get());
        assertEquals(0,parseInt("FIVE").orElse(0));
        assertEquals(0,parseInt("*").orElse(0));
    }

    @Test
    public void testPersonImmutable(){
        Person person = new Person("K",10);

        assertEquals(10,person.getAge());
        assertThrows(UnsupportedOperationException.class,()->person.setName(""));


    }
}
