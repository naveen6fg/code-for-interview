package interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringProblemsViaStream {
    public static void main(String[] args) {

        String [] input = {"debug=true", "runDate=2024"};

        //Example: Store into Map key = debug and Value = true
        //Output : debug -> true , runDate -> 2024


        LinkedHashMap<String, String> collect = Arrays.stream(input).collect(Collectors.toMap(w -> w.split("=")[0], w -> w.split("=")[1], (existing, replacement) -> existing, LinkedHashMap::new));
        //(existing, replacement) -> existing): Ensures that if there are duplicate keys, the first value is kept.
        System.out.println("1 :"+collect);

        //count  "k" letter's occurance in string
        String text = "kdjsgfdlakfkksiew";

        long count1 = Arrays.stream(text.split("")).filter(ch -> ch.equalsIgnoreCase("k")).count();
        long count2 = text.chars().mapToObj(ch -> (char) ch).filter(ch -> String.valueOf(ch).equalsIgnoreCase("k")).count();

        System.err.println("2 :"+count1);
        System.err.println("3 :"+count2);

        List<String> list = Arrays.asList("Rohit sjfdk", "Sohan kumar", "mohan dhgs");

        List<String> filteredList = list.stream()
                .filter(word -> Arrays.stream(word.split("")) // Split word into characters
                        .filter(c -> c.equalsIgnoreCase("a")) // Filter for 'a'
                        .count() > 0) // Keep word if it contains at least 1 'a'
                .collect(Collectors.toList());
        System.out.println("4 :"+filteredList);

        //        i/p - {Rohith, Harry, Dillip}find frequency of 'h' in element
        //        o/p - {Rohith=2, Harry=1, Dillip=0}
        Map<String, Long> h = Arrays.stream("Rohith, Harry, Dillip".split(", "))
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.chars().mapToObj(c -> (char) c)
                                .filter(c -> String.valueOf(c).equalsIgnoreCase("h"))
                                .count()));
        System.out.println(h);
    }
}
