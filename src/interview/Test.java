package interview;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 5, 7, 8, 9, 0);

        list.stream().sorted(Comparator.comparingInt(Integer::intValue));


        int sum1 = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        System.out.println();

        Integer sum2 = list.stream().reduce((a, b) -> a + b).get();
        System.out.println(sum2);

        List<Integer> list1 = list.stream().sorted((v1, v2) -> v2.compareTo(v1)).toList();
        List<Integer> list2 = list.stream().sorted(Comparator.reverseOrder()).toList();

        System.err.println("Descending sorted list with lambda :" + list1);
        System.err.println("Descending sorted list, without lambda :" + list2);

        List<Integer> list3 = list.stream().sorted((v1, v2) -> v1.compareTo(v2)).toList();
        List<Integer> list4 = list.stream().sorted().toList();

        System.err.println("Ascending sorted list, with lambda :" + list3);
        System.err.println("Ascending sorted list without lambda :" + list4);

        int[] arr = {1, 3, 4, 6, 7};

        System.out.println();
        Arrays.stream(arr).map(n -> n * 2).boxed().forEach(System.out::println);
    }

}
