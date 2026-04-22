package com.corejavaconcept.comparator;

import java.util.Comparator;

public class SortByPrice implements Comparator<Product> {


    @Override
    public int compare(Product o1, Product o2) {
      //  return Double.compare(o1.price,o2.price);
     return (int) (o1.price-o2.price);
    }
}
