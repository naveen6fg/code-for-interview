package com.corejavaconcept;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Generic {
    public static void main(String[] args) {
        //Importance of Generic here

        //without generic
        List as1 = Arrays.asList(87,98,27);
        Object collect1 = as1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        //with generic
        List<Integer> as2 = Arrays.asList(87,98,27);
        Map<Integer, Long> collect2 = as2.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

    }
}
