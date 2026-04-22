package interview;

public class Anagram {

    public static void main(String[] args) {
        String text1 = "maan".toLowerCase();
        String text2 = "mama".toLowerCase();

        int[] arr = new int[26];

        for (char ch1 : text1.toCharArray()) {
            arr[ch1 - 'a']++;
        }
        for (char ch2 : text2.toCharArray()) {
            arr[ch2 - 'a']--;

        }
        for (int a : arr) {
            if (a != 0) {
                System.out.println("Not an anagram");
                return;
            }
        }
        System.out.println("Its a anagram");


    }
}
