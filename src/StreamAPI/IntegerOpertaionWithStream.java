package StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerOpertaionWithStream {

    public static void main(String[] args) {

        String str = "My Name is Naveen Kumar";

        int[] arr = {26,14,22,5,6,11,76,25,19};


        Arrays.stream(str.toUpperCase().split(" ")).sorted().forEach(x->System.out.print(x+" "));
        System.out.println();
        Arrays.stream(str.toUpperCase().split(" ")).sorted(Comparator.reverseOrder()).forEach(x->System.out.print(x+" "));
        System.out.println();
        Arrays.stream(str.toUpperCase().split(" ")).sorted((o1,o2)->o1.compareTo(o2)).forEach(x->System.out.print(x+" "));
        System.out.println();
        Arrays.stream(arr).boxed().sorted((o1,o2)->Integer.compare(o1,o2)).forEach(x->System.out.print(x+" "));
        System.out.println();
        Arrays.stream(arr).boxed().sorted((o1,o2)->Integer.compare(o2,o1)).forEach(x->System.out.print(x+" "));

        Arrays.stream(arr).boxed().collect(Collectors.toMap(e->e,e->{
            if (e%2==0 && e%3==0){
                return "z";
            } else if (e%3==0) {
                return "y";
            } else if (e%2==0) {
                return "x";
            }else
            return "not division";
        })).forEach((x,y)-> System.out.println(x+"=="+y));

    }
}
