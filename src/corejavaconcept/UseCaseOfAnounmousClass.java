package com.corejavaconcept;

 interface MyInterface2 {

        default void m2() {
            System.out.println("I'm default method..");
        }
    }

    public class UseCaseOfAnounmousClass {

        public static void main(String[] args) {

            MyInterface2 myRef = new MyInterface2() { //announmous class
                @Override
                public void m2() {
                    MyInterface2.super.m2();
                }


            };
    }
}
