package interview;

import java.util.*;
import java.util.stream.*;

public class use_boxed_and_mapToInt {
    public static void main(String[] args) {
        // Example with boxed():
        IntStream intStream = IntStream.range(1, 6); // 1, 2, 3, 4, 5
        List<Integer> integerList = intStream.boxed().collect(Collectors.toList());
        System.out.println("Using boxed(): " + integerList); // Output: [1, 2, 3, 4, 5]

        // Example with mapToInt():
        Stream<String> stringStream = Stream.of("apple", "banana", "cherry");
        int totalLength = stringStream.mapToInt(String::length).sum();
        System.out.println("Using mapToInt(): " + totalLength); // Output: 17
    }
}
