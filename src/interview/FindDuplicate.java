package interview;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicate {

    public static void main(String[] args) {
        Integer[] arr = {4,5,2,8,3,6,1,8,0,3,6,10,7,0,3,8,8};

        Set<Integer> unseen = new HashSet<>();
        Set<Integer> unseen1 = new HashSet<>();
        for (int a :arr) {
            System.err.println(unseen.add(a));
        }

        List<Integer> list = Arrays.stream(arr).filter(v -> !unseen.add(v)).toList();

        System.out.println(list);


        Map<Boolean,List<Integer>> data =  Arrays.stream(arr).collect(Collectors.partitioningBy(v->unseen1.add(v)));

        System.out.println(data.get(true));
        System.out.println(data.get(false));

        Map<Integer,Long> collect  = Arrays.stream(arr).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(v -> v.getValue() > 2).collect(Collectors.toMap(v -> v.getKey(), v -> v.getValue()));

        System.out.println(collect);
    }
}
