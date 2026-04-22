package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlateningListOfList {

    public static void main(String[] args) {

        // How can you flatten a list of lists into a single list using Streams?

        List<List<String>> listOfObjects = Arrays.asList(Arrays.asList("Apple", "Banana", "Pomegranate", "Orange"), Arrays.asList("Peagon", "Parrot", "KuKu"), Arrays.asList("Cow", "Calf", "Buffalo", "Rhino", "Lame"));

        //listOfObjects.stream().flatMap(List::stream).forEach(System.out::println);
        List<String> singleList = listOfObjects.stream().flatMap(x -> x.stream()).collect(Collectors.toList()); //flattening list of list
        System.out.println(singleList);

        //Diff bw map()  an flatmap()

        List<String> fruits = List.of("Banana", "Straberry", "Apple", "Santra");

        List<List<Character>> listOfChOfAllWord = fruits.stream().map(fruit -> fruit.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList())).collect(Collectors.toList());

        System.out.println("Map() :"+listOfChOfAllWord);

        List<Character> listOfChar =  fruits.stream().flatMap(fruit->fruit.chars().mapToObj(ch->(char)ch)).collect(Collectors.toList());

        System.out.println("FlatMap() :"+listOfChar);
    }
}
