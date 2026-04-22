    package interview;

    import java.util.Arrays;
    import java.util.List;
    import java.util.Map;
    import java.util.concurrent.atomic.AtomicInteger;
    import java.util.stream.Collectors;

    public class Test2 {

        public static void main(String[] args) {

            List list = Arrays.asList(77,34,87,12);

            AtomicInteger integer = new AtomicInteger(1);
            Object collect = list.stream().collect(Collectors.toMap(e -> e, e -> integer.getAndIncrement()));

            System.out.println(collect);

            //Importance of Generic here
            List as1 = Arrays.asList(87,98,27);
            Object collect1 = as1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

            List<Integer> as2 = Arrays.asList(87,98,27);
            Map<Integer, Long> collect2 = as2.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        }
    }
