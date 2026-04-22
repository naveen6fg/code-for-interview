package com.corejavaconcept;

interface MyInterface{
    void m1();
    void m2();
}

//Same
//abstract class MyInterface{
//    abstract void m1();
//    abstract void m2();
//}

public class AnounmousClassImplementation {

    public static void main(String[] args) {


        MyInterface anoun = new MyInterface() {

            @Override
            public void m1() {
                System.out.println("Implementation of m1() method in Anounmous Class");
            }
            @Override
            public  void m2(){

                System.out.println("Implementation of m2() method in Anounmous Class");
            }

        };

       anoun.m1();
       anoun.m2();

    }
}
