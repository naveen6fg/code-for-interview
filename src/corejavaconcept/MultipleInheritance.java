package com.corejavaconcept;


interface MyInterface11 {

    default void m1() {
        System.out.println("This is m1 method..");
    }
}

interface MyInterface22 {

    default void m1() {
        System.out.println("This is m2 method");
    }
}

 class MultipleInhertance implements MyInterface11, MyInterface22 {

    public static void main(String[] args) {

        new MultipleInhertance().m1();

    }

    @Override
    public void m1() {
        MyInterface11.super.m1();
        MyInterface22.super.m1();
    }
}

