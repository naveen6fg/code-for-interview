package com.corejavaconcept.comparator;

import java.util.*;

public class TestProduct {
    public static void main(String[] args) {

        List<Product> list = Arrays.asList(new Product(22, "Name", 9789), new Product(21, "Deepake", 876), new Product(43, "jaspreet", 123));

        System.out.println("Before SOrt by ID");
        System.out.println(list);

        System.out.println("After SOrt By ID");
        Collections.sort(list,new SortById());
        System.out.println(list);


        System.out.println("=========================");

        System.out.println("Before SOrt by Name");
        System.out.println(list);

        System.out.println("After SOrt By Name");
        Collections.sort(list,new SortByName());
        System.out.println(list);

        System.out.println("=========================");

        System.out.println("Before SOrt by Price");
        System.out.println(list);

        System.out.println("After SOrt By Price");
        Collections.sort(list,new SortByPrice());
        System.out.println(list);

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "aello";
        String str4 = "Aello";

        //The compareTo method in Java is used to compare two String values lexicographically
        //If o2.name comes before o1.name alphabetically, it returns a negative value.
        //If o2.name comes after o1.name, it returns a positive value.
        //If both names are equal, it returns 0.
//        int returnValue = str1.compareTo(str2);
//        int returnValue1 = str3.compareTo(str2);
//        int returnValue2 = str3.compareTo(str1);
//        System.out.println();
//        System.out.println(returnValue);
//        System.out.println(returnValue1);
//        System.out.println(returnValue2);


    }
}
