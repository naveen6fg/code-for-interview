package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamProblemOnly {
    public static void main(String[] args) {

        // 1. IntStream.of(int... values)

        IntStream stream1 = IntStream.of(1, 2, 3, 4, 5);

// 2. IntStream.range(int startInclusive, int endExclusive)
        IntStream stream2 = IntStream.range(1, 5); // Output: 1, 2, 3, 4

// 3. IntStream.rangeClosed(int startInclusive, int endInclusive)
        IntStream stream3 = IntStream.rangeClosed(1, 5); // Output: 1, 2, 3, 4, 5

// 4. Arrays.stream(int[] array)
        int[] array = {1, 2, 3, 4, 5};
        IntStream stream4 = Arrays.stream(array); // most confusing

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

        Integer[] array2 = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(list1.toString().replaceAll("[\\[\\]]","").split(", ")).mapToInt(e -> Integer.parseInt(e)).sum();
        int sum1 = list1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = list1.stream().mapToInt(e -> e).sum();

        System.out.println(sum+"  "+sum1+"  "+sum2);


// 5. Stream.mapToInt(ToIntFunction<? super T> mapper)
        Stream<String> stream5 = Stream.of("1", "2", "3");
        IntStream intStream5 = stream5.mapToInt(Integer::parseInt); // Output: 1, 2, 3

// 6. Stream.flatMapToInt(Function<? super T, ? extends IntStream> mapper)
        Stream<List<Integer>> stream6 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4));
        IntStream intStream6 = stream6.flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)); // Output: 1, 2, 3, 4

// 7. IntStream.concat(IntStream a, IntStream b)
        IntStream a = IntStream.of(1, 2, 3);
        IntStream b = IntStream.of(4, 5, 6);
        IntStream combined = IntStream.concat(a, b); // Output: 1, 2, 3, 4, 5, 6


      //  Write a Java 8 program to find the sum of the first 10 natural numbers ?

        OptionalInt reduce  = IntStream.rangeClosed(1, 10).reduce((x, y) -> x * y);
        System.out.println(reduce.getAsInt());

        //most repeated string
        int[] arr = {1, 2, 3, 4, 2, 2, 3, 4, 4, 4, 5, 5, 4};

        Map.Entry<Integer, Long> integerLongEntry = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e -> e, LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue())).limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e,r)->r,LinkedHashMap::new));


        System.out.println(collect);
        System.out.println(integerLongEntry);

        //List<Integer> collect1 = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        List<Integer> collect2 = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder( )).collect(Collectors.toList());
        //System.out.println(collect1);
        System.out.println(collect2);


    }
}
