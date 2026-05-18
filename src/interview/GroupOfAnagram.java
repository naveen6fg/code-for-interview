package interview;

import java.util.*;

public class GroupOfAnagram {

    public static void main(String[] args) {

        String[] str = {"ant","ats","tan","sat","pan","nat","ast"};

        Map<String,List<String>> map = new HashMap();

        for (String s : str) {

          char[] ch =   s.toCharArray();

            Arrays.sort(ch);

           String sortedArray =  new String(ch);

           map.computeIfAbsent(sortedArray, k-> new ArrayList<>());

           map.get(sortedArray).add(s);

        }

        System.out.println(map.values());

    }
}
