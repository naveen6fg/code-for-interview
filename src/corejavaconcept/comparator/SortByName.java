package com.corejavaconcept.comparator;

import java.util.Comparator;

public class SortByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
       return o2.name.compareTo(o1.name);
    }
}
