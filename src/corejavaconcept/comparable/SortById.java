package com.corejavaconcept.comparable;

public class SortById implements Comparable<Employee>{

    @Override
    public int compareTo(Employee o) {
       // return Integer.compare(this.id, o.id); //we can't do this
        return 0;
    }
}
