//package com.strings;
//
//import com.google.common.collect.LinkedListMultimap;
//import com.google.common.collect.Multimap;
//
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class MaxCharOccReturn {
//
//    public static void main(String[] args) {
//
//        Multimap<String, Integer> multiMap = LinkedListMultimap.create();
//
//        String str = "a,a,c,c,c,c,d,d,d,d,c,c,c,c,c,a,a,a,a,b,b,g,b,b,b";
//        String[] strArr = str.split(",");
//
//        int k = 0;
//        int count = 1;
//
//        for (; k < strArr.length -1 ; k++) {
//
//            while (k < strArr.length - 1 && strArr[k].equals(strArr[k + 1]) ) {
//                count++;
//                k++;
//            }
//            multiMap.put(strArr[k], count);
//            count = 1;
//        }
//
//        System.out.println(multiMap);
//
//        Scanner sc = new Scanner(System.in);
//        System.out.printf("Enter ch to find max : ");
//        String str1 = sc.next();
//
//
//        Integer max = multiMap.get(str1).stream().max(Comparator.comparing(Integer::intValue)).get();
//
//        System.out.println(str1+" :"+max);
//
//    }
//}
