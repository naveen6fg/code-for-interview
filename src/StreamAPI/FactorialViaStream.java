package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FactorialViaStream {
    public static void main(String[] args) {

        int num = 10;

        System.out.println(IntStream.rangeClosed(1, num).reduce(1, (a, b) -> a * b));

        System.out.println();

        Stream.iterate(1, n -> n <= 20, n -> n +2).forEach(System.out::println);
        System.out.println();
        Stream.iterate(1,n -> n+2).limit(5).forEach(System.out::println);

        List<Integer> list = IntStream.rangeClosed(1, 200000).boxed().toList();

        List<Integer> result = list.stream()
                .filter(x -> x > 10) // Sequential
                .parallel()          // Switch to parallel
                .map(x -> x * 2)     // Parallel
                .toList();


        System.out.println();

        //0.0086245
        long start1 = System.nanoTime();
        List<Integer> list1 = list.stream().map(x -> x * 2).toList();
        long end1 = System.nanoTime();
        System.out.println("Time taken for sequential stream this operation :"+(end1-start1)+"ns");

        System.out.println();

        // 0.0165947
        long start2 = System.nanoTime();
        List<Integer> list2 = list.parallelStream().map(x -> x * 2).toList();
        long end2 = System.nanoTime();
        System.out.println("Time taken for parallelStream() stream ops :"+(end2-start2)+"ns");

        //0.0220567
        System.out.println();

        long start3 = System.nanoTime();
        List<Integer> list3 = list.stream().parallel().map(x -> x * 2).toList();
        long end3 = System.nanoTime();
        System.out.println("Time taken for stream().parallel() stream ops :"+(end3-start3)+"ns");


    }
}
