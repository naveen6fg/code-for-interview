package com.corejavaconcept.comparator;

import java.util.Comparator;

public class SortById implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.id- o2.id;
    }
}
