package StreamAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringOpsOccureances {

    public static void main(String[] args) {

        String str1 = "Todya Is Good Day";
        //output TIGD
        String[] strArr = str1.split(" ");
        StringBuffer finalStr= new StringBuffer();
        for (String word : strArr){
            char[] charArray = word.toCharArray();
            finalStr.append(Character.toString(charArray[0]));
        }
        System.out.println("Final String :"+finalStr);
        System.out.println();





        String str2 = "TodyaIsGoodDay";
        String[] words = str2.split("(?=[A-Z])");
        //output [aydoT][sI][dooG][yaD]

        String collect = Arrays.stream(words).map(x -> "[" + new StringBuffer(x).reverse().toString() + "]").collect(Collectors.joining());
        System.out.println("Final Output :"+collect);
        System.out.println();

        String str3 = "This but optimized approach not only reduces the time complexity to linear but also uses memory more efficiently by minimizing the creation of intermediate strings";
        //Occurance Each Chartere as well as word

        String[] s = str3.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word:s){

            if(!map.containsKey(word)){
                map.put(word,1);
            }else{
                map.put(word,map.get(word)+1);
            }
        }
        System.out.println("Each Word and their occurance : "+map);
        System.out.println();
        Map<Character, Integer> map1 = new HashMap<>();

        for (Character ch : str3.toCharArray()){

            if(!map1.containsKey(ch)){
                map1.put(ch,1);
            }else{
                map1.put(ch,map1.get(ch)+1);
            }
        }
        System.out.println("Each Character and their occurance :"+map1);

        //USing stream counting occurance of each word
        System.out.println();
        Stream.of(s).collect(Collectors.groupingBy(e->e, Collectors.counting())).forEach((x,y)-> System.out.print(x+"=="+y+" "));
        System.out.println();
        str3.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(e->e,Collectors.counting())).forEach((x,y)-> System.out.print(x+"=="+y+" "));




    }
}
