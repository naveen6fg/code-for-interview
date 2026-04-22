package strings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatingAndNonRepeatingCharacter {
    public static void main(String[] args) {

        String input = "abcbca";

        //First charter going to repeat soon

        HashSet<Character> set = new HashSet();

        char firstCh = '\0';
        for (char c : input.toCharArray()) {
            if (!set.add(c)){
                firstCh=c;
                break;
            }
        }
        System.out.println("First repeated character without stream:"+firstCh);

        set.clear();

        input.chars().mapToObj(c->(char)c)
                .filter(c->!set.add(c)).findFirst()
                .ifPresentOrElse(c-> System.out.println("First repeated character with stream :"+c),()-> System.out.println("No repeating char found"));

        //First repeated character \

        Map.Entry<Character, Long> characterLongEntry = input.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(v -> v.getValue() > 1)
                //.map(Map.Entry::getKey)
                .findFirst()
                .get();

        Character c = input.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(v -> v.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println(characterLongEntry);
        System.out.println(c);

        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(formattedDateTime);
        System.out.println(new Date().toString());



    }
}
