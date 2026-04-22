package StreamAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterDuplicate {
    public static void main(String[] args) {

        int[] arr = {6, 3, 8, 12, 9, 11, 3, 6, 10, 2, 1, 20, 12};

        Set set1 = new HashSet();
        Set set2 = new HashSet();

        for (int a : arr) {
            if (!set1.add(a)) {
                set2.add(a);
            }
        }
        System.out.println(set2);
        System.out.println();



        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting())).forEach((x, y) ->
        {
            if (y > 1) {
                System.out.println(x + "==" + y);
            }
        });

        System.out.println();

        Arrays.stream(arr).boxed().
                collect(Collectors.groupingBy(e -> e, Collectors.counting())).
                entrySet().stream().filter(value -> value.getValue() > 1).map(k -> k).
                forEach(x -> System.out.println(x.getKey() + "==" + x.getValue()));

        System.out.println("Duplicate data :");
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).boxed().filter(num -> !set.add(num)).forEach(x-> System.out.print(" "+x));
    }


}
