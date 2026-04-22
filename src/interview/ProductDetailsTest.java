package interview;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProductDetailsTest {

    private int prodId;
    private String prodName;
    private String prodCategory;
    private double prodPrice;

    public ProductDetailsTest(int prodId, String prodName, String prodCategory, double prodPrice) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodCategory = prodCategory;
        this.prodPrice = prodPrice;
    }

    @Override
    public String toString() {
        return "ProductDetailsTest{" + "prodId=" + prodId + ", prodName='" + prodName + '\'' + ", prodCategory=" + prodCategory + ", prodPrice=" + prodPrice + '}';
    }

    public int getProdId() {
        return prodId;
    }
    public void setProdId(int prodId) {
        this.prodId = prodId;
    }
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public String getProdCategory() {
        return prodCategory;
    }
    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory;
    }
    public double getProdPrice() {
        return prodPrice;
    }
    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public static void main(String[] args) {

        List<ProductDetailsTest> pList = Arrays.asList(
                new ProductDetailsTest(21, "Chips", "Snacks", 657),
                new ProductDetailsTest(21, "Soda", "Beverages", 120),
                new ProductDetailsTest(23, "Bread", "Bakery", 50),
                new ProductDetailsTest(24, "Milk", "Dairy", 60),
                new ProductDetailsTest(25, "Butter", "Dairy", 200),
                new ProductDetailsTest(26, "Apple", "Fruits", 150),
                new ProductDetailsTest(27, "Banana", "Fruits", 60),
                new ProductDetailsTest(28, "Chicken", "Meat", 400),
                new ProductDetailsTest(29, "Rice", "Grains", 120),
                new ProductDetailsTest(30, "Lentils", "Grains", 80),
                new ProductDetailsTest(31, "Chocolate", "Snacks", 99)
        );

        Map<Integer, ProductDetailsTest> mapData = pList.stream()
                .collect(Collectors.toMap(ProductDetailsTest::getProdId, e -> e, (existing, replace) -> existing));
        //(existing, replace)->existing ----->a merge function, used to resolve collisions between values associated with the same key, as supplied to Map. merge(Object, Object, BiFunction), must be non-null
        System.out.println(mapData);

        //First repeating charcter
        String input = "abcdexedcba";
        Character firstRepeatedChar = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> 1,
                        Integer::sum,  //Resolves conflicts when the same key appears multiple times (e.g., when a character repeats in the stream).
                        LinkedHashMap::new
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First repeating charcter :"+firstRepeatedChar);
        //First non-repeating charcter

        LinkedHashMap<Character, Long> collect1 = input.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));

        Map.Entry<Character, Long> characterLongEntry = collect1.entrySet().stream().filter(v -> v.getValue() == 1).findFirst().get();

        System.out.println("non repating :" + characterLongEntry);

        Character c1 = input.chars().mapToObj(c -> (char) c).filter(c -> collect1.get(c) == 1).findFirst().get();

        System.err.println("non repating :" + c1);


        //        i/p - {Rohith, Harry, Dillip}find frequency of 'h' in element
        //        o/p - {Rohith=2, Harry=1, Dillip=0}
        Map<String, Long> h = Arrays.stream("Rohith, Harry, Dillip".split(", "))
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.chars().mapToObj(c -> (char) c)
                                .filter(c -> String.valueOf(c).equalsIgnoreCase("h"))
                                .count()));
        System.out.println(h);

        List<String> list = Arrays.asList("Naveen Kumar", "Dinkar Mishra","Aditya Yadav", "Preeti B", "Ratnesh T");
        String strList[] = {"Naveen Kumar", "Dinkar Mishra","Aditya Yadav", "Preeti B", "Ratnesh T"};
        List<Integer> numList = Arrays.asList(22, 4, 45, 65, 22, 990);

        Stream<String> stream1 = list.stream(); 
        Stream<String> stream2 = Arrays.stream(strList);
         
        int[] arr1 = {75,22,7,32,56,22,56};
        Integer[] arr2 = {75,22,7,32,56,22,56};

        IntStream intStream1 = Arrays.stream(arr1);  //premitive type data
        Stream<Integer> stream3 = Arrays.stream(arr2); //non-premitivetypeData
        Stream<Integer> stream4 = numList.stream(); //non-premitivetypeData

        int sum1 = intStream1.sum();//IntStream(Interface) having mathematic opertion methods like, sum(), max(),avarage()
        //  stream3.sum(); //Error  -> caused //Stream (Interface) doesn't have sum() method

        int sum = stream3.mapToInt(Integer::intValue).sum(); //mapToInt() convert Stream<Integer> to IntStream

       //intStream1.collect(Collectors.toList()); //Error  ->  caused //.collect(Collectors.toList()) doesn't work with IntStream


       // stream has already been operated upon or closed
        //List<Integer> collect3 = intStream1.boxed().collect(Collectors.toList());// convert IntStream to Stream<Integer>
        //List<Integer> collect = stream3.collect(Collectors.toList());


        //Sorting last name, using toMap()
        LinkedHashMap<String, String> collect = list.stream().collect(Collectors.toMap(firstName -> firstName.split(" ")[0], lastName -> lastName.split(" ")[1], (e, r) -> r, LinkedHashMap::new)).entrySet().stream()
                .sorted((v1, v2) -> v1.getValue().compareTo(v2.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e, r) -> r, LinkedHashMap::new));

        LinkedHashMap<String, String> collect4 = list.stream()
                .map(name -> name.split(" "))
                .sorted((a, b) -> a[1].compareTo(b[1])) // Sort by last name
                .collect(Collectors.toMap(
                        arr -> arr[0], // First name as key
                        arr -> arr[1], // Last name as value
                        (e, r) -> r,   // Handle duplicates
                        LinkedHashMap::new // Maintain insertion order
                ));



        System.out.println(collect.toString().replaceAll("[\\{\\}]", "").replaceAll("[\\=]", " "));

         // Sorting using string methods()
        List<String> list1 = list.stream().sorted(Comparator.comparing(name -> name.substring(name.lastIndexOf(" ") + 1))).toList();

        System.out.println(list1);
    }

}
