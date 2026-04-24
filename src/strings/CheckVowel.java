package strings;

public class CheckVowel {

    public static void main(String[] args) {

        String str ="My Name is Naveen".toLowerCase();
        // int count =0;

        Long count1 = str.chars().mapToObj(ch->(char)ch).filter(ch->(String.valueOf(ch).equals("a")|String.valueOf(ch).equals("e")|String.valueOf(ch).equals("i")|String.valueOf(ch).equals("o")|String.valueOf(ch).equals("u"))).count();
        Long count2 =  str.chars().mapToObj(ch->(char)ch).filter(ch->String.valueOf(ch).matches("[aeiou]")).count();
        Long count3 =  str.chars().mapToObj(ch->(char)ch).filter(ch->"aeiouAEIOU".contains(String.valueOf(ch))).count();
        Long count4 = str.chars().mapToObj(ch->(char)ch).filter(ch->ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u').count();

        System.out.println("Vowel count :"+count1);
        System.out.println("Vowel count :"+count2);
        System.out.println("Vowel count :"+count3);
        System.out.println("Vowel count :"+count4);

        //SELECT empName, empSal
        //FROM employee
        //WHERE empSal = (
        //    SELECT DISTINCT empSal
        //    FROM employee
        //    ORDER BY empSal DESC
        //    LIMIT 1 OFFSET 4
        //);

//        SELECT empName, empSal
//        FROM employee
//        ORDER BY empSal DESC
//        LIMIT 1 OFFSET 4;


      Long count =   str.chars().mapToObj(ch->(char)ch).filter(ch->String.valueOf(ch).matches("[aeiou]")).count();
        System.out.println("Count : "+count);
    }
}
