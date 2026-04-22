package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class PerformanceTest {
    public static void main(String[] args) {
        // Create a list of integers from 1 to 200,000
        List<Integer> list = IntStream.rangeClosed(1, 200000).boxed().toList();

        // Warm-up phase
        for (int i = 0; i < 5; i++) {
            list.stream().map(x -> x * 2).toList();
            list.parallelStream().map(x -> x * 2).toList();
            list.stream().parallel().map(x -> x * 2).toList();
        }

        // Measure performance
        int iterations = 10;
        long sequentialTime = 0;
        long parallelStreamTime = 0;
        long parallelMethodTime = 0;

        for (int i = 0; i < iterations; i++) {
            // Sequential Stream
            long startTime1 = System.nanoTime();
            List<Integer> list1 = list.stream().map(x -> x * 2).toList();
            sequentialTime += System.nanoTime() - startTime1;

            // Parallel Stream
            long startTime2 = System.nanoTime();
            List<Integer> list2 = list.parallelStream().map(x -> x * 2).toList();
            parallelStreamTime += System.nanoTime() - startTime2;

            // Stream with .parallel()
            long startTime3 = System.nanoTime();
            List<Integer> list3 = list.stream().parallel().map(x -> x * 2).toList();
            parallelMethodTime += System.nanoTime() - startTime3;
        }

        // Calculate average time
        System.out.println("Average Sequential Stream Time: " + (sequentialTime / iterations) + " ns");
        System.out.println("Average Parallel Stream Time: " + (parallelStreamTime / iterations) + " ns");
        System.out.println("Average Stream with .parallel() Time: " + (parallelMethodTime / iterations) + " ns");




    }
}