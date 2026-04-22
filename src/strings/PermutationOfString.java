package strings;

import java.util.Arrays;
import java.util.stream.Stream;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "ABC";

        int[] index = new int[6];
        Arrays.fill(index,6);

        Arrays.stream(index).forEach(System.out::println);

        Stream.of(index).flatMapToInt(Arrays::stream).forEach(System.out::println);


        System.out.printf(index.toString());
    }
}
