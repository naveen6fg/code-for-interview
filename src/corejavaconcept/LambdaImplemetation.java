package com.corejavaconcept;

interface MyInterfaceFunctionalInterface {
    void m1(int a,double b);

    default void m2() {
        System.out.println("I'm default method..");
    }
}

public class LambdaImplemetation {

    public static void main(String[] args) {

        MyInterfaceFunctionalInterface  ref = (a,b)->{
            System.out.println(a+b);
        };

        ref.m1(2,4.70);

        ref.m2();

    }
}
