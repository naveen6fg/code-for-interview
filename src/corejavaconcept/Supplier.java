package com.corejavaconcept;

import java.util.stream.Stream;

interface MySupplier{

    double m1();
}

public class Supplier {

    public static void main(String[] args) {

        MySupplier supp = () ->{
          return Math.random();
        };

        System.out.println( supp.m1());
    }
}
