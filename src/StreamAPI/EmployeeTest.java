package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

    static List<Employee> empList = null;
    static {
        empList = Arrays.asList(new Employee(11, "Rajan k", 678978),
                new Employee(17, "Priya Singh", 345678),
                new Employee(18, "Anil Kumar", 456123),
                new Employee(19, "Pooja Nair", 567890),
                new Employee(20, "Amit Patel", 678123),
                new Employee(21, "Meera Shastri", 789456),
                new Employee(22, "Vikram Desai", 890789),
                new Employee(23, "Pooja Nair", 901234),
                new Employee(24, "Lakshmi Rao", 123789),
                new Employee(25, "Arjun S", 234890),
                new Employee(26, "Ravi Sharma", 345123),
                new Employee(27, "Sunita Chauhan", 456234),
                new Employee(28, "Neeraj Pandey", 567345),
                new Employee(29, "Anil Kumar", 678456),
                new Employee(30, "Pooja Nair", 789567));
    }

    public static void main(String[] args) {

        List<Employee> collect = empList.stream().
                sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

         System.out.println(collect);
         System.out.println();


         String str =  "Naveen Kumar";

        long e1 = Stream.of(str).filter(e -> e.equalsIgnoreCase("e")).count();

        System.out.println(e1);

        String input = "abcdexedcba";


        LinkedHashMap<Character, Long> collect1 = input.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));

        Map.Entry<Character, Long> characterLongEntry = collect1.entrySet().stream().filter(v -> v.getValue() == 1).findFirst().get();

        System.out.println(characterLongEntry);




        Stream.of("Naveen Kumar".replaceAll(" ","").split("")).collect(Collectors.groupingBy(k->k,Collectors.counting())).forEach((k,v)-> System.out.println(k+"="+v));
    }
}
