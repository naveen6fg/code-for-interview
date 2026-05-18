package StreamAPI;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoiner {

    public static void main(String[] args) {

        StringJoiner sj = new StringJoiner("::");

        sj.add("add");

        sj.add("sub");
        sj.add("div");

        System.out.println(sj.toString());

        String str = Stream.of(1, 2, 3).map(num -> String.valueOf(num)).collect(Collectors.joining("::", "[", "]"));


        Stream.of("String", "Naveen", "Pankaj").map(String::toUpperCase).map(st -> {

                    char[] ch = st.toCharArray();
                    Arrays.sort(ch);
                    return new String(ch);
                }
        ).sorted().forEach(System.out::println);


        System.out.println(str);
    }
}
