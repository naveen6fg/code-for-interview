package com.corejavaconcept;

public interface Functionalitr_2 extends Functionalitr_1 {
    abstract void m1();// when only this method in interfcace("Functionalitr_2") then still its functional interface
    abstract void m2(); //if only the this method in interfcace("Functionalitr_2") then it will  inherit the method of
                        // interface("Functionalitr_1) m1() then m1()+m2() , no longer functional interface
}
