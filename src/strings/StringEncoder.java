package strings;

public class StringEncoder {

    public static void main(String[] args) {

        System.out.println(encodeString("a"));         // Output: a1
        System.out.println(encodeString("aa"));        // Output: a2
        System.out.println(encodeString("aabbb"));     // Output: a2b3
        System.out.println(encodeString("aabbbaa"));
    }

    private static String encodeString(String input) {

        StringBuffer bf = new StringBuffer();
        char currentCharcter = input.charAt(0);
        int count = 1;                                           //index  1=a,2=a,3=b,4=b,5=b,6=a  but for another last "a" of aabbbaa will be left anf for loop will be falsed
        for (int i = 1; i < input.length(); i++) { //for ie-> "aabbbaa" total character=7 but here in loop starting inedex from, 1 to 6

            if (currentCharcter == input.charAt(i)) {
                count++;
            } else {
                bf.append(currentCharcter).append(count);
                currentCharcter = input.charAt(i);
                count = 1;
            }
        }

        // Append the last character and its count
        bf.append(currentCharcter).append(count);

        return bf.toString();
    }
}
