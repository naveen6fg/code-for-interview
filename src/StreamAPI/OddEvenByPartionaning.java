package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.partitioningBy;

public class OddEvenByPartionaning {

    public static void main(String[] args) {

        Map<Boolean, List<Integer>> collect1 = Stream.of(55, 8, 28, 2, 1, 8, 27, 10, 28).collect(partitioningBy(e -> e % 2 == 0));

        System.out.println("Name length above three charcter :" + collect1.get(true));
        System.out.println("Name length below three charcter :" + collect1.get(false));
        System.out.println();

        Map<Boolean, List<String>> collect2 = Stream.of("Shyam", "Tom", "Manny", "Pankaj", "RA").collect(partitioningBy(name -> name.length() > 3));
        System.out.println("Enven No :" + collect2.get(true));
        System.out.println("Odd No :" + collect2.get(false));
        System.out.println();

        Map<Boolean, Long> collect3 = Stream.of(55, 8, 28, 2, 1, 8, 27, 10, 28).collect(partitioningBy(e -> e % 2 == 0, Collectors.counting()));
        System.out.println("Even count :" + collect3.get(true));
        System.out.println("Odd count :" + collect3.get(false));
        System.out.println();


        String str =  "Ma:laya;la@M"; //malayalam
        str =  str.replaceAll("[\\;\\@ \\:]+","").toUpperCase();

        System.out.println(str);
        System.out.println();

        boolean equals = Stream.of(str.split(" ")).map(e -> new StringBuilder(e).reverse().toString()).collect(Collectors.joining()).equals(str);

        System.out.println(equals);
        System.out.println();

        //find sum
        List<Integer> oneToTen =  Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum1 = oneToTen.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum : "+sum1);


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum2 = Arrays.stream(arr).sum();
        System.out.println("sum : "+sum2);

        System.out.println(arr);
        System.out.println(Arrays.toString(arr)); //Good one

        System.out.println();
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);

        Collection<List<Integer>> evenOddList = oneToTen.stream()
                .collect(collectingAndThen(partitioningBy(i -> i % 2 == 0),
                        Map::values));

        System.out.println(evenOddList);
        Map<Boolean, List<Integer>> evenAddOddSeparation = oneToTen.stream()
                .collect(partitioningBy(i -> i % 2 == 0));

        System.out.println(evenAddOddSeparation);


}}



